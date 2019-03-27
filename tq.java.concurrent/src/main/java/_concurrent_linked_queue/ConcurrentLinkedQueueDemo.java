package _concurrent_linked_queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 734070824@qq.com
 * @date 2019/3/26 10:25
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
    }
}
