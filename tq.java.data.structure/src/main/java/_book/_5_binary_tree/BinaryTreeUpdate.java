package _book._5_binary_tree;

/**
 * 二叉树操作接口
 * @author 734070824@qq.com
 * @date 2018/8/14 16:05
 */
public class BinaryTreeUpdate implements IBinaryTreeUpdate{


    @Override
    public <T> BinNode<T> insertAsLC(T t, BinNode<T> parent) {
        BinNode node = new BinNode(t);
        node.parent = parent;
        parent.lChild = node;
        //TODO 高度
        return node;
    }

    @Override
    public <T> BinNode<T> insertAsRC(T t, BinNode<T> parent) {
        BinNode node = new BinNode(t);
        node.parent = parent;
        parent.rChild = node;
        //TODO 高度
        return node;
    }
}
