package _book._algorithms_4th_edition._3_search._3_3_balanced_search_trees._avl_tree;

/**
 * 平衡二叉树
 * @author 734070824@qq.com
 * @date 2018/2/9 11:16
 */
public class AVLTree<V extends Comparable<V>>{

    public AVLNode<V> root;

    public AVLTree(V v) {
        root = new AVLNode(v);
    }

    public AVLNode<V> findMax(AVLNode<V> key){
        if(key == null){
            return null;
        }
        if(key.right == null){
            return key;
        }
        return findMax(key.right);
    }


    public AVLNode<V> findMin(AVLNode<V> key){
        if(key == null){
            return null;
        }
        if(key.left == null){
            return key;
        }
        return findMax(key.left);
    }

    public AVLNode<V> insert(AVLNode<V> key, V x){
        if(key == null){
            key = new AVLNode<V>(x);
        }else if(x.compareTo(key.data) < 0){
            key.left = insert(key.left, x);
            //判断平衡
            if(height(key.left) - height(key.right) > 1){
                //两种情况
                if(x.compareTo(key.left.data) < 0){
                    key = leftLeftRotation(key);
                }else {
                    key = leftRightRotation(key);
                }
            }
        }else {
            key.right = insert(key.right, x);
            if(height(key.right) - height(key.left) > 1){
                if(x.compareTo(key.right.data) > 0){
                    key = rightRightRotation(key);
                } else {
                    key = rightLeftRotation(key);
                }
            }
        }
        key.height = max(height(key.left), height(key.right)) + 1;
        return key;
    }

    public boolean delete(AVLNode<V> key, V x){
        if(key == null){
            return  false;
            //找到要删除的节点
        }else if(x.compareTo(key.data) == 0){
            //左右子树都不为空
            if(key.left != null && key.right != null){
                //在高度更高的那个子树上进行删除操作

                //左子树高度大, 删除左子树中值最大的节点, 将其赋给根节点
                if(height(key.left) > height(key.right)){
                    key.data = findMax(key.left).data;
                    delete(key.left, key.data);
                }else {
                    key.data = findMin(key.right).data;
                    delete(key.right, key.data);
                }
            }else {
                //左右子树有一个不为空，直接用需要删除的结点的子结点替换即可
                AVLNode<V> old = key;
                key = key.left != null ? key.left : key.right;
            }
            //待删除的节点在左子树
        }else if(x.compareTo(key.data) < 0){
            delete(key.left, x);
            //是否满足平衡条件
            if(height(key.right) - height(key.left) > 1){
                if(height(key.right.left) > height(key.right.right)){
                    key = rightLeftRotation(key);
                }else {
                    key = rightRightRotation(key);
                }
            }else {
                key.height = max(height(key.left), height(key.right)) + 1;
            }
        }else {
            //右子树
            delete(key.right, x);
            if(height(key.left) - height(key.right) > 1){
                if(height(key.left.right) > height(key.left.left)){
                    key = leftRightRotation(key);
                }else {
                    key = leftLeftRotation(key);
                }
            }else {
                key.height = max(height(key.left), height(key.right)) + 1;
            }
        }

        return true;
    }


    





    /**
     * LL旋转
     *      6           6             4
     *    4   9 -->   4    9  -->   3   6    6(失衡点)
     *   3 5         3 5           2   5  9
     *              2
     *
     * @param key 失衡点
     * @return
     */
    public AVLNode<V> leftLeftRotation(AVLNode<V> key) {
        AVLNode tmp = key.left;
        key.left = tmp.right;
        tmp.right = key;
        key.height = max(height(key.left), height(key.right)) + 1;
        tmp.height = max(height(tmp.left), height(tmp.right)) + 1;
        return tmp;
    }

    /**
     * RR旋转
     * @param key 失衡点
     * @return
     */
    public AVLNode<V> rightRightRotation(AVLNode<V> key) {
        AVLNode tmp = key.right;
        key.right = tmp.left;
        tmp.left = key;
        key.height = max(height(key.left), height(key.right)) + 1;
        tmp.height = max(height(tmp.left), height(tmp.right)) + 1;
        return tmp;
    }

    /**
     *  LR旋转
     *
     *     8                     8                      6
     *  4       12  ---RR-->   6    12 ---LL-->      4   8
     *2   6                  4  7                  2    7  12
     *      7               2
     * @param key 失衡点
     * @return
     */
    public AVLNode<V> leftRightRotation(AVLNode<V> key) {
        //失衡点的左节点 RR
        key.left = rightRightRotation(key.left);
        //失衡点 LL
        return leftLeftRotation(key);
    }

    /**
     * RL 旋转
     * @param key 失衡点
     * @return
     */
    public AVLNode<V> rightLeftRotation(AVLNode<V> key) {
        //失衡点的右节点 LL
        key.right = leftLeftRotation(key.right);
        //失衡点 RR
        return rightRightRotation(key);
    }




    private int max(int a, int b) {
        return a>b ? a : b;
    }


    //获取树的高度
    private int height(AVLNode<V> tree) {
        if (tree != null)
            return tree.height;
        return 0;
    }

    public int height() {
        return height(root);
    }

}
