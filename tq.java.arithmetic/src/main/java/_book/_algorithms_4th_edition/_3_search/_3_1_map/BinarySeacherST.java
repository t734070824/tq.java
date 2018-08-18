package _book._algorithms_4th_edition._3_search._3_1_map;

/**
 * 二分查找 基于有序数组
 * @author 734070824@qq.com
 * @date 2018/8/18 15:07
 */
public class BinarySeacherST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySeacherST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    boolean isEmpty() {
        return size() == 0;
    }


    public Value get(Key key){
        if(isEmpty()){
            return  null;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }else {
            return null;
        }
    }

    public void put(Key key, Value value){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = value;
            return;
        }
        //TODO 扩容

        //向后移动 假设数组未满
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Key mid(){
        return keys[0];
    }

    public Key max(){
        return keys[N -1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int rank = rank(key);
        return keys[rank];
    }

    /**
     * <= key的最大键
     * @param key
     * @return
     */
    public Key floor(Key key){
        int rank = rank(key);
        //如果包含key keys[rank]
        //如果不包含key keys[rank-1]
        //TODO contain
        return keys[rank -1];
    }




    public void delete(Key key){
        //TODO delete
        //向前移动

    }


    public int rank(Key key){
        return rank(key, 0, keys.length);
    }

    public int rank(Key key, int lo, int hi){
        if(lo > hi) {
            return lo;
        }
        int mid = lo + (hi - lo) /2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0){
            return rank(key, lo, mid - 1);
        }else if(cmp > 0){
            return rank(key, mid + 1, hi);
        }else {
            return mid;
        }
    }

    public int rankWhile(Key key){
        int lo = 0;
        int hi = N -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) /2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                hi = mid -1;
            }else if(cmp > 0){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return lo;
    }

}
