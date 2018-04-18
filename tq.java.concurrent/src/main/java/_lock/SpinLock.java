package _lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author 734070824@qq.com
 * @date 2018/4/18 11:07
 */
public class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
        Thread currentThread = Thread.currentThread();

        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, currentThread)) {
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        // 只有锁的拥有者才能释放锁
        owner.compareAndSet(currentThread, null);
    }
}
