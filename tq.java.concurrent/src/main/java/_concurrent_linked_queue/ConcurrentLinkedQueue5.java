package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue5<E> {

    private AtomicReference<Node<E>> dummy;
    public ConcurrentLinkedQueue5() {
        dummy = new AtomicReference<>(new Node<>(null, null));
    }

    public E poll(){
        while (true){
            Node<E> curDummy = dummy.get();
            Node<E> curNext = curDummy.next;
            E oldItem = curNext.item.get();
            //T1: cas dummy
            if(dummy.compareAndSet(curDummy, curNext)){
                //T1, 处于 S2, 尝试T2: cas dummy.item
                curDummy.item.compareAndSet(oldItem, null);
                //成功标识 该消费者C1, 连续完成了 T1, T2, 队列处于 S1
                //失败 标识 T2 已由C2 完成, 队列处于 S1
                return oldItem;
            }
            //失败得知队处于 S2,  尝试 T2: cas dummy.item
            curDummy.item.compareAndSet(oldItem, null);
            // 如果成功，队列转换到S1；如果失败，队列表示T2已经由消费者P1完成，队列已经处于S1
            // 然后循环，重新尝试T1

        }
    }

    private static class Node<E> {
        private AtomicReference<E> item;
        private volatile Node<E> next;
        public Node(AtomicReference<E> item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
