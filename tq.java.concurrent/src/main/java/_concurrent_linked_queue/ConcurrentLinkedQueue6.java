package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue6<E> {

    private AtomicReference<Node<E>> head;
    public ConcurrentLinkedQueue6() {
        throw new UnsupportedOperationException("Not implement");
    }
    public E poll(){
        while (true){
            Node<E> curHead = head.get();
            Node<E> curNext = curHead.next;
            //T1: cas head
            if(head.compareAndSet(curHead, curNext)){
                // 完成 T1, 处于 S1
                return curHead.item;
            }
            //失败重试
        }
    }

    private static class Node<E> {
        private volatile E item;
        private volatile Node<E> next;
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
