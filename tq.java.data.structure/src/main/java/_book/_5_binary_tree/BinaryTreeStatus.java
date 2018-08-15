package _book._5_binary_tree;

/**
 * @author 734070824@qq.com
 * @date 2018/8/14 16:14
 */
public class BinaryTreeStatus implements IBinaryTreeStatus{
    @Override
    public boolean isRoot(BinNode x) {
        return x.parent == null;
    }

    @Override
    public boolean isLChind(BinNode x) {
        return !isRoot(x) && x == x.parent.lChild;
    }

    @Override
    public boolean isRChind(BinNode x) {
        return !isRoot(x) && x == x.parent.rChild;
    }

    @Override
    public boolean hasParent(BinNode x) {
        return !isRoot(x);
    }

    @Override
    public boolean hasLChild(BinNode x) {
        return x.lChild != null;
    }

    @Override
    public boolean hasRChild(BinNode x) {
        return x.rChild != null;
    }

    @Override
    public boolean hasChild(BinNode x) {
        return hasLChild(x) || hasRChild(x);
    }

    @Override
    public boolean hasBothChild(BinNode x) {
        return hasLChild(x) && hasRChild(x);
    }

    @Override
    public boolean isLeaf(BinNode x) {
        return !hasChild(x);
    }
}
