package _book._5_binary_tree;

/**
 * 二叉树操作接口
 * @author 734070824@qq.com
 * @date 2018/8/14 16:05
 */
public interface IBinaryTreeTrav {

    /**
     * 作为当前节点的左孩子插入当前节点
     * @param t
     * @param <T>
     * @return
     */
    <T> BinNode<T> insertAsLC(T t);

    /**
     * 作为当前节点的右孩子插入当前节点
     * @param t
     * @param <T>
     * @return
     */
    <T> BinNode<T> insertAsRC(T t);


    /**
     * 先序遍历
     * @param node
     */
    void travPre(BinNode node);

    /**
     * 中序遍历
     * @param node
     */
    void travIn(BinNode node);


    /**
     * 后序遍历
     * @param node
     */
    void travPost(BinNode node);
}
