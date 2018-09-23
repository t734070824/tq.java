package _book._algorithms_4th_edition._2_rank._2_4_priority_queue;

/**
 * @author 734070824@qq.com
 * @date 2018/9/22 15:45
 */
public class MaxPQ<Key extends  Comparable<Key>> {

    //基于堆的完全二叉树
    private Key[] pq;
    //存储于pq[1...N], pq[0] 没有使用
    private  int N;

    public MaxPQ() {
    }

    /**
     * 最大容量为 max 的优先队列
     * @param max
     */
    public MaxPQ(int max){
        pq = (Key[]) new Comparable[max + 1];
    }


    /**
     * 用 a[] 中元素 创建一个优先队列
     * @param a
     */
    public MaxPQ(Key[] a){

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key k) {
        pq[N++] = k;
        swim(N);
    }


    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }



    public Key max() {
        return null;
    }






    /**
     * 节点上浮
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * 节点下沉
     * @param k
     */
    private void sink(int k) {
        while (2*k <= N){
            int j = 2*k;
            if(j < N & less(j, j+1)) {
                j++;
            }
            if(!less(k, j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 交换
     * @param i
     * @param k
     */
    private void exch(int i, int k) {
    }

    public boolean less(int k, int i) {
        return pq[k].compareTo(pq[i]) < 0;
    }

    public static void main(String[] args) {
        System.err.println(new Integer(3).compareTo(new Integer(2)));
    }
}
