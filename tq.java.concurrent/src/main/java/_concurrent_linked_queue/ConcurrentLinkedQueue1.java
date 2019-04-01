package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue1<E> {

    private volatile Node<E> tail;

    public ConcurrentLinkedQueue1() {
        throw new UnsupportedOperationException("Not implement");
    }

    public boolean offer(E e){
        Node<E> newNode = new Node<>(e, new AtomicReference<>(null));
        while (true){
            Node<E> curTail = tail;
            AtomicReference<Node<E>> curNext = curTail.next;
            //尝试 T1, cas 设置 tail.next
            if(curNext.compareAndSet(null, newNode)){
                //成功 获取独占锁, 完成 T1, 直接完成T2: 设置 tail
                tail = curNext.get();
                return true;
            }
            //失败者 自动自旋
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
