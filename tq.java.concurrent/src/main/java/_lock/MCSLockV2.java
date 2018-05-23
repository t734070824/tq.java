package _lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/**
 * @author 734070824@qq.com
 * @date 2018/5/23 17:24
 */
public class MCSLockV2 {
    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;

    public void lock() {
        QNode qnode = myNode.get();
        QNode pred = tail.getAndSet(qnode);
        if (pred != null) {
            qnode.locked = true;
            pred.next = qnode;

            // wait until predecessor gives up the lock
            while (qnode.locked) {
            }
        }
    }

    public void unlock() {
        //TODO 感觉写的不对
        QNode qnode = myNode.get();
        if (qnode.next == null) {
            if (tail.compareAndSet(qnode, null))
                return;

            // wait until predecessor fills in its next field
            while (qnode.next == null) {
            }
        }
        qnode.next.locked = false;
        qnode.next = null;
    }

    class QNode {
        boolean locked = false;
        QNode next = null;
    }
}