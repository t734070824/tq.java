package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue3<E> {

    private AtomicReference<Node<E>> tail;

    public ConcurrentLinkedQueue3() {
        throw new UnsupportedOperationException("Not implement");
    }

    public boolean offer(E e){
        Node<E> newNode = new Node<>(e, new AtomicReference<>(null));
        while (true){
            Node<E> curTail = tail.get();
            AtomicReference<Node<E>> curNext = curTail.next;
            //先检查一下队列状态的状态，tail.next==null表示队列处于状态S1，仅此时才有CAS尝试T1的必要
            if(curNext.get() == null){
                //尝试 T1, cas 设置 tail.next
                if(curNext.compareAndSet(null, newNode)){

                    //成功完成 T1, 队列 处于 S2, 继续尝试 T2: cas 设置 tail
                    tail.compareAndSet(curTail, curNext.get());
                    // 成功表示该生产者P1完成连续完成了T1、T2，队列处于S1
                    // 失败表示T2已经由生产者P2完成，队列处于S1
                    return true;
                }
            }
            // 失败者得知队列处于S2，则尝试T2：CAS设置tail
            tail.compareAndSet(curTail, curNext.get());
            // 如果成功，队列转换到S1；如果失败，队列表示T2已经由生产者P1完成，队列已经处于S1
            // 然后循环，重新尝试T1
        }
    }

    private static class Node<E> {
        private volatile E item;
        private AtomicReference<Node<E>> next;
        public Node(E item, AtomicReference<Node<E>> next) {
            this.item = item;
            this.next = next;
        }
    }
}
