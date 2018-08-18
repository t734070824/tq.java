package _book._algorithms_4th_edition._3_search._3_1_map;

import java.util.Iterator;

/**
 * 顺序查找, 基于链表
 * @author 734070824@qq.com
 * @date 2018/8/18 13:49
 */
public class SequentialSearchST<Key, Value> {

    //首节点
    private Node first;
    private int size;

    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value){
        for(Node x = first; x != null; x = x.next){
            //命中
            if(key.equals(x.key)){
                x.value = value;
                return ;
            }
        }
        //没有命中, 新增节点
        first = new Node(key, value, first);
        size++;
    }

    public int size(){
        return size;
    }

    public Iterator<Key> keys(){
        return new Iterator<Key>() {
            private Node lastReturn;
            private Node next = first;
            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public Key next() {
                lastReturn = next;
                next = next.next;
                return lastReturn.key;
            }
        };
    }

    public void delete(Key key){
        Node last = null;
        for(Node x = first; x != null; x = x.next){
            //命中
            if(key.equals(x.key)){

                if(key.equals(first.key)){
                    first = first.next;
                }else {
                    //此时 last != null
                    last.next = x.next;
                }
                x = null;
                return ;
            }
            last = x;
        }
    }



    private class Node{
        Key key;
        Value value;

        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }


}
