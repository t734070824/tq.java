package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue7<E> {
    private AtomicReference<Node<E>> dummy;
    private AtomicReference<Node<E>> tail;
    public ConcurrentLinkedQueue7() {
        Node<E> initNode = new Node<E>(
                new AtomicReference<E>(null), new AtomicReference<Node<E>>(null));
        dummy = new AtomicReference<>(initNode);
        tail = new AtomicReference<>(initNode);
        // Node<E> head = dummy.get().next.get();
    }

    public boolean offer(E e){

    }



    private static class Node<E> {
        private AtomicReference<E> item;
        private AtomicReference<Node<E>> next;
        public Node(AtomicReference<E> item, AtomicReference<Node<E>> next) {
            this.item = item;
            this.next = next;
        }
    }
}
