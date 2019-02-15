package _book._algorithms_4th_edition._2_rank._2_4_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 从N个输入中找到最大M个元素
 * @author 734070824@qq.com
 * @date 2018/9/22 15:50
 */
public class TopM<E extends Comparable> {

    private PriorityQueue queue;
    private int maxSize; // 堆的最大容量

    public TopM(int maxSize) {
        if (maxSize <= 0)
            throw new IllegalArgumentException();
        this.maxSize = maxSize;
        this.queue = new PriorityQueue(maxSize, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                // 生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 比较规则
                return (o2.compareTo(o1));
            }
        });
    }

    public void add(E e) {
        // 未达到最大容量，直接添加
        if (queue.size() < maxSize) {
            queue.add(e);
        } else { // 队列已满
            E peek = (E) queue.peek();
            // 将新元素与当前堆顶元素比较，保留较小的元素
            if (e.compareTo(peek) < 0) {
                queue.poll();
                queue.add(e);
            }
        }
    }
}
