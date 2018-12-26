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
    }
``` 


