2018-12-26

## 源码分析

```java

public class ThreadPoolExecutor extends AbstractExecutorService {
    public void execute(Runnable command) {
            if (command == null)
                throw new NullPointerException();
            int c = ctl.get();
            //活动线程数 < corePoolSize
            if (workerCountOf(c) < corePoolSize) {
                //直接启动线程, addWorker(Runnable firstTask, boolean core)
                // core 表示是否检查 workerCount < corePoolSize
                if (addWorker(command, true))
                    return;
                //任务添加失败
                c = ctl.get();
            }
            //线程池在运行状态并且 任务成功添加到队列
            if (isRunning(c) && workQueue.offer(command)) {
                // 重新检测
                int recheck = ctl.get();
                // 不在运行状态, 并且移除任务成功, 则 拒绝任务
                if (! isRunning(recheck) && remove(command))
                    reject(command);
                // 线程池处于RUNNING状态 || (线程池处于非RUNNING状态但是任务移除失败)
                else if (workerCountOf(recheck) == 0)
                    // 这行代码是为了SHUTDOWN状态下没有活动线程了，但是队列里还有任务没执行这种特殊情况。
                    // 添加一个null任务是因为SHUTDOWN状态下，线程池不再接受新任务
                    addWorker(null, false);
            }
            // 1.非RUNNING状态拒绝新的任务
            // 2.队列满了启动新的线程失败（workCount > maximumPoolSize）
            else if (!addWorker(command, false))
                reject(command);
        }
    
    private boolean addWorker(Runnable firstTask, boolean core) {
            retry:
            for (;;) {
                int c = ctl.get();
                //当前线程池状态
                int rs = runStateOf(c);
    
                // Check if queue empty only if necessary.
                /**
                * 条件转换为 rs >= SHUTDOWN && (rs != SHUTDOWN || firstTask != null || workQueue.isEmpty())
                * 满足下列条件则直接返回false，线程创建失败:
                *   rs > SHUTDOWN: STOP||TIDYING||TERMINATED  此时不在接受新的任务, 且所有任务执行结束
                *   rs = SHUTDOWN &&  firstTask != null: 此时不再接受任务, 但是仍然会执行队列汇总的任务
                *   rs = SHUTDOWN && firtTask == null && workQueue.isEmpty(): 见execute方法的addWorker(null,false)，任务为null && 队列为空
                *   最后一种情况也就是说SHUTDONW状态下，如果队列不为空还得接着往下执行，为什么?
                *   add一个null任务目的到底是什么?
                *        看execute方法只有workCount==0的时候firstTask才会为null结合这里的条件就是线程池SHUTDOWN了不再接受新任务
                *        但是此时队列不为空，那么还得创建线程把任务给执行完才行。
                */
                if (rs >= SHUTDOWN &&
                    ! (rs == SHUTDOWN &&
                       firstTask == null &&
                       ! workQueue.isEmpty()))
                    return false;
    
                //走到这的情形：
                // 1.线程池状态为RUNNING
                // 2.SHUTDOWN状态，但队列中还有任务需要执行
                for (;;) {
                    int wc = workerCountOf(c);
                    if (wc >= CAPACITY ||
                        wc >= (core ? corePoolSize : maximumPoolSize))
                        return false;
                    // 原子操作递增workCount
                    if (compareAndIncrementWorkerCount(c))
                        // 操作成功跳出的重试的循环
                        break retry;
                    c = ctl.get();  // Re-read ctl
                    //如果线程池的状态发生变化则重试
                    if (runStateOf(c) != rs)
                        continue retry;
                    // else CAS failed due to workerCount change; retry inner loop
                }
            }
    
            // wokerCount递增成功
            
            boolean workerStarted = false;
            boolean workerAdded = false;
            Worker w = null;
            try {
                w = new Worker(firstTask);
                final Thread t = w.thread;
                if (t != null) {
                     // 并发的访问线程池workers对象必须加锁
                    final ReentrantLock mainLock = this.mainLock;
                    mainLock.lock();
                    try {
                        // Recheck while holding lock.
                        // Back out on ThreadFactory failure or if
                        // shut down before lock acquired.
                        int rs = runStateOf(ctl.get());
    
                        // RUNNING状态 || SHUTDONW状态下清理队列中剩余的任务
                        if (rs < SHUTDOWN ||
                            (rs == SHUTDOWN && firstTask == null)) {
                            if (t.isAlive()) // precheck that t is startable
                                throw new IllegalThreadStateException();
                            // **将新启动的线程添加到线程池中**
                            workers.add(w);
                            int s = workers.size();
                             // 更新largestPoolSize
                            if (s > largestPoolSize)
                                largestPoolSize = s;
                            workerAdded = true;
                        }
                    } finally {
                        mainLock.unlock();
                    }
                    
                    // 启动新添加的线程，这个线程首先执行firstTask，然后不停的从队列中取任务执行
                    // 当等待keepAlieTime还没有任务执行则该线程结束。见runWoker和getTask方法的代码。
                    if (workerAdded) {
                        t.start();
                        workerStarted = true;
                    }
                }
            } finally {
                // 线程启动失败，则从wokers中移除w并递减wokerCount
                if (! workerStarted)
                    // 递减wokerCount会触发tryTerminate方法
                    addWorkerFailed(w);
            }
            return workerStarted;
        }
        
    final void runWorker(Worker w) {
            Thread wt = Thread.currentThread();
            Runnable task = w.firstTask;
            w.firstTask = null;
            // Worker的构造函数中抑制了线程中断setState(-1)，所以这里需要unlock从而允许中断
            w.unlock(); // allow interrupts
            // 用于标识是否异常终止，finally中processWorkerExit的方法会有不同逻辑
            // 为true的情况：1.执行任务抛出异常；2.被中断。
            boolean completedAbruptly = true;
            try {
                
                // 如果getTask返回null那么getTask中会将workerCount递减，如果异常了这个递减操作会在processWorkerExit中处理
                while (task != null || (task = getTask()) != null) {
                    w.lock();
                    // If pool is stopping, ensure thread is interrupted;
                    // if not, ensure thread is not interrupted.  This
                    // requires a recheck in second case to deal with
                    // shutdownNow race while clearing interrupt
                    if ((runStateAtLeast(ctl.get(), STOP) ||
                         (Thread.interrupted() &&
                          runStateAtLeast(ctl.get(), STOP))) &&
                        !wt.isInterrupted())
                        wt.interrupt();
                    try {
                        // 任务执行前可以插入一些处理，子类重载该方法
                        beforeExecute(wt, task);
                        Throwable thrown = null;
                        try {
                            task.run();
                        } catch (RuntimeException x) {
                            thrown = x; throw x;
                        } catch (Error x) {
                            thrown = x; throw x;
                        } catch (Throwable x) {
                            thrown = x; throw new Error(x);
                        } finally {
                            // 和beforeExecute一样，留给子类去重载
                            afterExecute(task, thrown);
                        }
                    } finally {
                        task = null;
                        w.completedTasks++;
                        w.unlock();
                    }
                }
                completedAbruptly = false;
            } finally {
                // 结束线程的一些清理工作
                processWorkerExit(w, completedAbruptly);
            }
        }    
        
    private Runnable getTask() {
            boolean timedOut = false; // Did the last poll() time out?
    
            for (;;) {
                int c = ctl.get();
                int rs = runStateOf(c);
    
                // Check if queue empty only if necessary.
                //1.rs > SHUTDOWN 所以rs至少等于STOP,这时不再处理队列中的任务
                //2.rs = SHUTDOWN 所以rs>=STOP肯定不成立，这时还需要处理队列中的任务除非队列为空
                //这两种情况都会返回null让runWoker退出while循环也就是当前线程结束了，所以必须要 decrementWorkerCount
                if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
                    // 递减workerCount值
                    decrementWorkerCount();
                    return null;
                }
    
                int wc = workerCountOf(c);
    
                // Are workers subject to culling?
                // 标记从队列中取任务时是否设置超时时间
                boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
    
                /*
                 * wc > maximumPoolSize的情况是因为可能在此方法执行阶段同时执行了setMaximumPoolSize方法；
                 * timed && timedOut 如果为true，表示当前操作需要进行超时控制，并且上次从阻塞队列中获取任务发生了超时
                 * 接下来判断，如果有效线程数量大于1，或者阻塞队列是空的，那么尝试将workerCount减1；
                 * 如果减1失败，则返回重试。
                 * 如果wc == 1时，也就说明当前线程是线程池中唯一的一个线程了。
                 */
                if ((wc > maximumPoolSize || (timed && timedOut))
                    && (wc > 1 || workQueue.isEmpty())) {
                    // workerCount递减，结束当前thread
                    if (compareAndDecrementWorkerCount(c))
                        return null;
                    continue;
                }
    
                try {
                    /*
                     * 根据timed来判断，如果为true，则通过阻塞队列的poll方法进行超时控制，如果在keepAliveTime时间内没有获取到任务，则返回null；
                     * 否则通过take方法，如果这时队列为空，则take方法会阻塞直到队列不为空。
                     * 
                     */
                    Runnable r = timed ?
                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                        workQueue.take();
                    if (r != null)
                        return r;
                     // 如果 r == null，说明已经超时，timedOut设置为true
                    timedOut = true;
                } catch (InterruptedException retry) {
                    // 如果获取任务时当前线程发生了中断，则设置timedOut为false并返回循环重试
                    timedOut = false;
                }
            }
        }

    }
``` 


