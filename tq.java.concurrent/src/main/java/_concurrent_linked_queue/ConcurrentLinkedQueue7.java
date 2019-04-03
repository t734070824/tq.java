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
        Node<E> newNode = new Node<>(new AtomicReference<>(e), new AtomicReference<>(null));
        while (true){
            Node<E> curTail = tail.get();
            AtomicReference<Node<E>> curNext = curTail.next;
            if(curNext.compareAndSet(null, newNode)){
                tail.compareAndSet(curTail, curNext.get());
                return true;
            }
            tail.compareAndSet(curTail, curNext.get());
        }
    }

    public E poll(){
        while (true){
            Node<E> curDummy = dummy.get();
            Node<E> curNext = curDummy.next.get();
            if(curNext == null){
                return null;
            }
            E oldItem = curNext.item.get();
            if(curNext.item.compareAndSet(oldItem, null)){
                dummy.compareAndSet(curDummy, curNext);
                return oldItem;
            }
            dummy.compareAndSet(curDummy, curNext);
        }
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
