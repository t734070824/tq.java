package _book._algorithms_4th_edition._3_search._3_3_balanced_search_trees;

import _book._algorithms_4th_edition._3_search._3_2_bst.BST;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 红黑树
 * 红黑: 由其父节点指向他的连接的颜色
 * @author 734070824@qq.com
 * @date 2018/8/30 20:01
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    /**
     * 左旋转
     * 将两个键中的较小值作为根节点 变为 较大者为根节点
     * @param h
     * @return
     */
    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }



    /**
     * 右旋转
     * 将两个键中的较小值作为根节点 变为 较大者为根节点
     * @param h
     * @return
     */
    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * 颜色转换
     * @param h
     */
    public void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        return x == null ? 0 : x.N;
    }

    private boolean isRed(Node x){
        return  x == null ? false : (x.color == RED);
    }


    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if(h == null){
            //标准的插入操作, 与父节点 红连接相连
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if(cmp < 0){
            h.left = put(h.left, key, value);
        }else if(cmp > 0){
            h.right = put(h.right, key, value);
        }else {
            h.value = value;
        }
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.right) && isRed(h.left)){
            flipColors(h);
        }
        h.N = size(h.left) +size(h.right) + 1;
        return h;
    }

    //TODO 红黑树的删除


    public static void main(String[] args) {
        char[] c = new char[]{'S', 'E', 'A', 'R', 'C', 'H', 'X', 'M'};
        RedBlackBST redBlackBST = new RedBlackBST();
        for (int i = 0; i < c.length; i++) {
            redBlackBST.put(c[i], "");
        }
        redBlackBST.put('P',"");

    }

    private class Node{
        Key key;
        Value value;
        Node right, left;
        int N;
        //由其父节点指向他的连接的颜色
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

}
