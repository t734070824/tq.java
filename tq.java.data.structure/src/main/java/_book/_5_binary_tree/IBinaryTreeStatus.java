package _book._5_binary_tree;

/**
 * 二叉树 状态
 * @author 734070824@qq.com
 * @date 2018/8/14 16:11
 */
public interface IBinaryTreeStatus{

    boolean isRoot(BinNode x);

    boolean isLChind(BinNode x);

    boolean isRChind(BinNode x);

    boolean hasParent(BinNode x);

    boolean hasLChild(BinNode x);

    boolean hasRChild(BinNode x);

    boolean hasChild(BinNode x);

    boolean hasBothChild(BinNode x);

    boolean isLeaf(BinNode x);








}
