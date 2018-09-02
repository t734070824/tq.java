package _book._algorithms_4th_edition._3_search._3_4_hashtable;

/**
 * 基于线性探测的符号表
 * @author 734070824@qq.com
 * @date 2018/9/2 10:39
 */
public class LinearProbingHashST<Key, Value> {

    //键值对总数
    private int N;
    //线性探测表的大小
    private int M;

    private Key[] keys;

    private Value[] values;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {
        keys = (Key[]) new Object[cap];
        values = (Value[]) new Object[cap];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    public void put(Key key, Value value){
        if(N > M /2) {
            resize(M*2);
        }
        int i;
        for(i = hash(key); keys[i] != null; i = (i+1) % M){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i+1)%M) {
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key){
        if(!contains(key)) {
            return;
        }
        //确定key的位置
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i+1)%M;
        }
        //删除
        keys[i] = null;
        values[i] = null;
        //下一个
        i = (i+1)%M;
        //后面的键重新插入
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i+1)%M;
        }
        N--;
        if(N > 0 && N == M/8) {
            resize(M/2);
        }

    }

    private boolean contains(Key key) {
        return get(key) != null;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if(keys[i] != null){
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }
}
