package _concurrent_linked_queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 734070824@qq.com
 * @date 2019/4/1 19:42
 */
public class ConcurrentLinkedQueue4<E> {

    private AtomicReference<Node<E>> dummy;
    public ConcurrentLinkedQueue4() {
        dummy = new AtomicReference<>(new Node<>(null, null));
    }

    public E poll(){
        while (true){
            Node<E> curDummy = dummy.get();
            Node<E> curNext = curDummy.next;
            E oldItem = curNext.item.get();
            //尝试 T1: cas 设置 dummy.next.item
            if(curNext.item.compareAndSet(oldItem, null)){
                //成功设置 , 完成 T1, 队列处于S2, 继续完成 T2, cas 设置 dummy
                dummy.compareAndSet(curDummy, curNext);
                // 成功表示该消费者C1完成连续完成了T1、T2，队列处于S1
                // 失败表示T2已经由消费者C2完成，队列处于S1
                return oldItem;
            }
            //失败, 得知 队列 处于 S2, 则 尝试T2: cas 设置 dummy
            dummy.compareAndSet(curDummy, curNext);
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
