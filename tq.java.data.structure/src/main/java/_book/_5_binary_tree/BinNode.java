package _book._5_binary_tree;

/**
 * 二叉树节点模板
 * @author 734070824@qq.com
 * @date 2018/8/13 16:59
 */
public class BinNode<T> {

    //数据
    T data;

    //父亲, 左孩子, 右孩子
    BinNode<T> parent;
    BinNode<T> lChild;
    BinNode<T> rChild;

    //高度
    int height;

    //颜色
    RBColor color;

    /**
     * 其他可选变量
     * depth 当前节点的深度
     * size 以当前节点的为根的子树规模
     * 虽然这些变量可以加速静态的查询或者搜索, 但是在二叉树结构发生改变的时候需要动态修改
     * 这些字段,
     *
     */

    public BinNode() {
        this.height = 0;
        this.color = RBColor.RB_RED;
    }

    public BinNode(T t) {
        this.height = 0;
        this.color = RBColor.RB_RED;
        this.data = t;
    }

    public BinNode(T data, BinNode<T> parent, BinNode<T> lChild, BinNode<T> rChild, int height, RBColor color) {
        this.data = data;
        this.parent = parent;
        this.lChild = lChild;
        this.rChild = rChild;
        this.height = height;
        this.color = color;
    }
}
