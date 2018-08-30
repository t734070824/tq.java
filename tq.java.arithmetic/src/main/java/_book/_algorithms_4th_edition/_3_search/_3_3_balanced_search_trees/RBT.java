package _book._algorithms_4th_edition._3_search._3_3_balanced_search_trees;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 红黑树
 * 红黑: 由其父节点指向他的连接的颜色
 * @author 734070824@qq.com
 * @date 2018/8/30 20:01
 */
public class RBT<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    /**
     * 左旋转
     * 将两个键中的较小值作为根节点 变为 较大者为根节点
     * @param h
     * @return
     */
    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right) + 1;
        return null;
    }

    //TODO rotateRight


    private boolean isRed(Node x){
        return  x == null ? false : (x.color == RED);
    }


    private class Node{
        Key key;
        Value value;
        Node left, right;
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
