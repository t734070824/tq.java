package _linked_list._skip_list;

/**
 * @author 734070824@qq.com
 * @date 2018/6/20 19:49
 */
public class SkipListEntry {

    public Integer key;
    public Integer value;

    public  int pos;//为了打印

    public SkipListEntry up, down, left, right;  //上下左右 四个指针

    public  static int negInf = Integer.MIN_VALUE;//负无穷

    public  static int posInf = Integer.MAX_VALUE;//正无穷

    public SkipListEntry(int key, Integer value) {
        this.key = key;
        this.value = value;

        up = down = left = right = null;
    }


    public int getValue() {
        return value;
    }



    public Integer getKey() {
        return key;
    }



    public Integer setValue(Integer val) {
        Integer oldValue = value;
        value = val;
        return oldValue;
    }

    public boolean equals(Object o) {
        SkipListEntry ent;
        try {
            ent = (SkipListEntry) o; // 检测类型
        } catch (ClassCastException ex) {
            return false;
        }
        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
}
