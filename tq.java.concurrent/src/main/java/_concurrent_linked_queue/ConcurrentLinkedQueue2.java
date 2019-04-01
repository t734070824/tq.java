package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue2<E> {

    private AtomicReference<Node<E>> tail;

    public ConcurrentLinkedQueue2() {
        throw new UnsupportedOperationException("Not implement");
    }

    public boolean offer(E e){
        Node<E> newNode = new Node<>(e, new AtomicReference<>(null));
        while (true){
            Node<E> curTail = tail.get();
            AtomicReference<Node<E>> curNext = curTail.next;
            //尝试 T1, cas 设置 tail.next
            if(curNext.compareAndSet(null, newNode)){

                //成功完成 T1, 队列 处于 S2, 继续尝试 T2: cas 这是tail
                tail.compareAndSet(curTail, curNext.get());
                // 成功表示该生产者P1完成连续完成了T1、T2，队列处于S1
                // 失败表示T2已经由生产者P2完成，队列处于S1
                return true;
            }
            // 失败者得知队列处于S2，则尝试T2：CAS设置tail
            tail.compareAndSet(curTail, curNext.get());
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
