package _tree._binary_tree;

/**
 * @author 734070824@qq.com
 * @date 2018/2/7 16:43
 */
public class TreeNode {
    int key;

    String data = null;

    boolean isVisted = false;

    TreeNode leftChild = null;

    TreeNode rightChild = null;

    public TreeNode() {
    }

    public TreeNode(int key, String data) {
        super();
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return key+"_"+data;
    }

    @Override
    public int hashCode() {
        return (key+"_"+data).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof TreeNode){
            TreeNode node = (TreeNode) obj;
            if(node.hashCode() == this.hashCode()) return true;
            else return false;
        } else{
            return false;
        }
    }
}
