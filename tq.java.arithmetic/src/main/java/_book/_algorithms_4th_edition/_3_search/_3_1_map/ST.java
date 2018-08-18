package _book._algorithms_4th_edition._3_search._3_1_map;

/**
 * 符号表 API
 * @author 734070824@qq.com
 * @date 2018/8/16 15:37
 */
public class ST<Key extends  Comparable<Key>, Value> {

    public ST() {
    }

    void put(Key key, Value value){

    }

    Value get(Key key) {
        return null;
    }

    void delete(Key key) {
        put(key, null);
    }

    boolean contain(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return 0;
    }

    /**
     * 最小的键
     * @return
     */
    Key min(){
        return null;
    }

    /**
     * 最大的键
     * @return
     */
    Key max(){
        return null;
    }

    /**
     * <= key的最大键
     * @param key
     * @return
     */
    Key floor(Key key){

        return key;
    }

    /**
     * >= key的最小键
     * @param key
     * @return
     */
    Key ceiling(Key key){

        return key;
    }

    /**
     * 小于key的数量
     * @param key
     * @return
     */
    int rank(Key key){

        return 0;
    }


    /**
     * 排名为K的键
     * @param k
     * @return
     */
    Key select(int k){

        return null;
    }

    void deleteMin(){
        delete(min());
    }

    void deleteMax(){
        delete(max());
    }

    /**
     * [lo, hi]之间的键数量
     * @param lo
     * @param hi
     * @return
     */
    int size(Key lo, Key hi){
        if(hi.compareTo(lo) < 0){
            return  0;
        }else if(contain(hi)){
            return rank(hi) - rank(lo) + 1;
        }else{
            return rank(hi) - rank(lo);
        }
    }

    /**
     * [lo, hi]之间的所有键
     * 已排序
     * @param lo
     * @param hi
     * @return
     */
    Iterable<Key> keys(Key lo, Key hi){
        return null;
    }



    Iterable<Key> keys() {
        return keys(min(), max());
    }




}
