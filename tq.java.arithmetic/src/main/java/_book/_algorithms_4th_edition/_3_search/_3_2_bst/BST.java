package _book._algorithms_4th_edition._3_search._3_2_bst;


import edu.princeton.cs.algs4.Queue;

/**
 * 二叉树
 * @author 734070824@qq.com
 * @date 2018/8/30 10:25
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size(){
        return size(root);
    }

    public int size(Node x){
        return x == null ? 0 : x.N;
    }

    public Value get(Key key){
        return get(key, root);
    }

    public Value get(Key key, Node x){
        if(x == null) {
            return null;
        }
        if(key.compareTo(x.key) < 0){
            return get(key, x.left);
        }else if(key.compareTo(x.key) > 0) {
            return get(key, x.right);
        }else{
            return x.value;
        }

    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, value);
        }else if(cmp > 0){
            x.right = put(x.right, key, value);
        }else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if(x.right == null){
            return x;
        }
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        return x == null ? null : x.key;
    }

    /**
     * 递归的思想
     * @param x
     * @param key
     * @return
     */
    public Node floor(Node x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        if(cmp < 0){
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t ;
        }else {
            return x;
        }

    }


    public Node ceiling(Node x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        if(cmp > 0){
            return floor(x.right, key);
        }
        Node t = floor(x.left, key);
        if (t != null) {
            return t ;
        }else {
            return x;
        }
    }

    public Key select(int k){
        Node x = select(root, k);
        return x == null ? null : x.key;
    }

    /**
     * 返回排名为K的节点
     * @param x
     * @param k
     * @return
     */
    private Node select(Node x, int k) {
        if(x == null){
            return null;
        }
        int t = size(x);
        if(t > k){
            return select(x.left, k);
        }else if(t < k){
            return select(x.right, k);
        }else {
            return x;
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if(x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return rank(x.left, key);
        }else if(cmp > 0){
            return rank(x.right, key);
        }else {
            return size(x);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x == null){
            return  null;
        }
        //可以仔细思考一下为什么这么写
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) - 1;
        return x;
    }

    public void deleteMax(){
        root  = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x == null){
            return  null;
        }
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) - 1;
        return x;
    }


    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null){
            return  null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = delete(x.left, key);
        }else if (cmp > 0){
            x.right = delete(x.right, key);
        }else {
            //这个时候 很是复杂
            //将右子树的最小节点代替x
            /**
             * 我的想法: 将整个左子树 移到右子树最小节点的左节点, 右子树的root代替x
             * 问题:
             *      1. 会使右子树长度边长, 增加查询深度
             */
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) - 1;
        return x;
    }

    /**
     * 中根遍历
     * @return
     */
    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if(x == null){
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);


        //这一段理解起来有些难度
        if(cmplo < 0){
            keys(x.left, queue, lo ,hi);
        }

        if(cmplo <= 0 && cmphi >= 0){
            queue.enqueue(x.key);
        }

        if(cmphi > 0){
            keys(x.right, queue, lo, hi);
        }


    }


    //max, min, floor, ceiling
    //select, rank
    //select, deleteMin, deleteMax
    //keys






    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        //以该节点为根的子树中的节点数
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(10, "1");
        bst.put(9, "1");
        bst.put(4, "1");
        bst.put(6, "1");
        bst.put(5, "1");
        bst.put(12, "1");
        bst.put(11, "1");
        bst.put(13, "1");

//        bst.deleteMin();

//        bst.delete(6);
        System.err.println("1");
        Iterable keys = bst.keys();
        System.err.println(keys);
    }
}
