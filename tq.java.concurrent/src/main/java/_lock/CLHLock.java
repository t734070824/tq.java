package _lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 思路 CLHLock
 * 1. 一个全局的CLHLock
 * 2. 每个线程都可以调用其lock方法，但只有一个线程能获得锁，其余线程等待
 * 3. 控制的方式是
 *      - 每次lock，先找到当前线程的代理节点（没有就新建），原子性地将其设置为tail
 *      - preNode指向原tail
 *      - 循环判定preNode的锁定状态，如果已经解锁，while循环终止
 *      - 每次unlock只需将锁定状态设置为false
 * @author 734070824@qq.com
 * @date 2018/4/18 10:28
 */
public class CLHLock implements Lock{


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool( 10 );
        CLHLock lock = new CLHLock();
        for (int i = 0; i < 10; i++) {
            service.submit( () -> {
                lock.lock();
                System.out.println( Thread.currentThread().getName() + ":I got the lock,but I do not release it." );
                //  程序永远得不到退出
                //lock.unlock();
                //  不仅如此，因为所有的线程都在自旋中，cpu一致处于繁忙状态，会导致假死
            } );
        }
        service.shutdown();
    }


    /**
     * 1. 是线程参与竞争的代理人,
     * 2. 每个竞争的线程在Lock中都有一个作为代表的 node 对象
     * 3. 获取锁的前提是 node 的上一个node解锁了
     */
    private static final class Node{
        boolean locked;
    }

    //当前线程第一个get的时候, 就会实例化一个 node 并且放入线程本地变量
    private ThreadLocal<Node> current = new ThreadLocal<Node>(){
        @Override
        protected Node initialValue() {
            return new Node();
        }
    };

    //pre 用于记录排队节点的前驱
    private  ThreadLocal<Node> pre = new ThreadLocal<>();

    //这记录了Node队列最后一个排队的Node，初始化时是一个unlock的node
    //为什么是 AtomicReference
    private AtomicReference<Node> tail = new AtomicReference<>(new Node());

    /**
     * //TODO 全是不可重入锁
     */
    public void lock() {
        //获取当前线程的代理排队点
        Node node = current.get();
        //设置锁定状态
        node.locked = true;
        //获取排队队列的最末的一个节点, 同时将tail指正指向当前线程的node
        //并重新设置 tail --> AtomicReference
        Node lastNode = tail.getAndSet(node);
        //设置当前线程的 前驱节点
        pre.set(lastNode);
        // 前一个node处于lock状态, 当前线程死循环自旋
        while (lastNode.locked){

        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * //TODO 我的理解:既然是尝试获取锁, 可以获取失败, 就没有必要放进队列里了
     * @return
     */
    public boolean tryLock() {
        // 当前线程的节点
        Node myNode = current.get();
        // 设置锁定状态
        myNode.locked = false;
        // 获得排队队列的最末一个节点，同时将tail指针指向当前线程的node
        //这里获得并重新设置，是原子的，多个线程同时视图将自己的节点加入末尾，只有一个线程能成功
        Node lastNode = tail.getAndSet( myNode );
        //记录此前最末的节点到线程本地变量中
        pre.set( lastNode );

        return !(lastNode.locked);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //TODO 没有判断当前节点是否获取锁
        // 当前线程的节点
        Node myNode = current.get();
        // 设置锁定状态为false，后继节点（线程）获得锁
        myNode.locked = false;

        //TODO lock的时候 设置的意义在哪里
        pre.set( null );
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
