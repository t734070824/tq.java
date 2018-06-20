package _linked_list._skip_list;

import java.util.Random;

/**
 * @author 734070824@qq.com
 * @date 2018/6/20 19:54
 */
public class SkipList {

    public SkipListEntry head;
    public SkipListEntry tail;

    public int n;//表中的元素个数

    public int h;//高度

    public Random r;

    public static void main(String[] args) {
        System.err.println(new SkipListEntry(null, null).right);
    }

    public SkipList() {
        SkipListEntry p1, p2;

        p1 = new SkipListEntry(SkipListEntry.negInf, null);
        p2 = new SkipListEntry(SkipListEntry.posInf, null);

        head = p1;
        tail = p2;

        p1.right = p2;
        p2.left = p1;

        n = 0;
        h=0;
        r = new Random();
    }

    public int size(){
        return n;
    }

    public boolean isEntry(){
        return n == 0;
    }

    //在最下面一层，找到要插入的位置前面的那个key
    public SkipListEntry findEntry(String k) {
        SkipListEntry p;
        p = head;

        while (true){
            while (p.right.key != SkipListEntry.negInf
                    && p.right.key.compareTo(k) <= 0){
                p = p.right;
            }
            //如果还有下一层 继续寻找
            if(p.down != null){
                p = p.down;
            }else {
                break;
            }

        }

        return p;
    }


    //返回key对应的值
    public Integer get(String k){
        SkipListEntry p = findEntry(k);
        if(k.equals(p.key)){
            return p.value;
        } else {
            return null;
        }
    }

    //放入 替换 并返回
    public Integer put(String k, Integer v){
        SkipListEntry p, q;

        int i;

        p = findEntry(k);
        if(k.equals(p.key)){
            Integer oldValue = p.value;
            p.value = v;
            return oldValue;
        }

        q = new SkipListEntry(k, v);
        q.left = p;
        q.right= p.right;
        p.right = q;
        p.right.left = q;

        i = 0;//当前level= 0
        while (r.nextDouble() < 0.5) {
            //如果超出了高度 ,重新建立一个顶层
            if(i>= h){
                SkipListEntry p1, p2;
                h++;
                p1 = new SkipListEntry(SkipListEntry.negInf, null);
                p2 = new SkipListEntry(SkipListEntry.posInf, null);

                p1.right=p2;
                p1.down=head;

                p2.left = p1;
                p2.down = tail;

                head.up = p1;
                tail.up = p2;

                head = p1;
                tail = p2;
            }


        }
    }




}
