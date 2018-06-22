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
        SkipList list = new SkipList();
        for (int i = 0; i < 100; i++) {
            int i1 = new Random().nextInt(100);
            list.put(i1 , i1);
        }

        list.printAll();



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
    public SkipListEntry findEntry(int k) {
        SkipListEntry p;
        p = head;

        while (true){
            while (p.right != null && p.right.key != SkipListEntry.negInf
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
    public Integer get(Integer k){
        SkipListEntry p = findEntry(k);
        if(k.equals(p.key)){
            return p.value;
        } else {
            return null;
        }
    }

    //放入 替换 并返回
    public Integer put(Integer k, Integer v){
        SkipListEntry p, q;

        int i;

        p = findEntry(k);

        //存在节点, 设置新值 返回旧值
        if(k.equals(p.key)){
            Integer oldValue = p.value;
            p.value = v;
            return oldValue;
        }

        q = new SkipListEntry(k, v);
        q.left = p;
        q.right= p.right;
        /**
         * 下面两行 顺序颠倒会导致死循环
         */
        p.right.left = q;
        p.right = q;

        printAll();
        i = 0;//当前level= 0
        // 再使用随机数决定是否要向更高level攀升
        if(q.left ==q){
            System.err.println(q);
        }
        while (r.nextBoolean()) {
            //如果超出了高度 ,重新建立一个顶层
            if(i>= h){
                addEmptyLevel();
                printAll();
            }

            //从 p 上 开始查找
            while (p.up == null){
                p = p.left;
            }

            p = p.up;

            // 新增和q指针指向的节点含有相同key值的节点对象
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            SkipListEntry z = new SkipListEntry(k, null);

            z.left = p;
            z.right = p.right;
            p.right.left = z;
            p.right = z;

            z.down = q;
            q.up = z;

            q = z;
            i = i + 1;

            if(z.left ==z){
                System.err.println(q);
            }

        }

        n = n + 1;

        // 返回null，没有旧节点的value值
        return null;
    }

    //删除节点的操作相对put就比较简单了，首先查找到包含key值的节点，将节点从链表中移除，接着如果有更高level的节点，则repeat这个操作即可。
    public Integer remove(Integer key) {
        SkipListEntry p, q;
        p = findEntry(key);
        if(!p.key.equals(key)){
            return  null;
        }

        Integer oldValue = p.value;
        while (p != null){
            q = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p = q;
        }

        return  oldValue;

    }

    private void addEmptyLevel() {

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

    public void printAll(){

        System.err.println("-------------------");
        StringBuilder sb = new StringBuilder();

        SkipListEntry next = head;
        SkipListEntry oldHead = head;
        while (next != null){
            sb.append(next).append("--");
            if(next.key.equals(SkipListEntry.posInf)){
                next = oldHead.down;
                oldHead = oldHead.down;
                sb.append("\n");
            } else {
                next = next.right;

            }
        }

        System.err.println(sb);
        System.err.println("-------------------");

    }


}
