package _tree._binary_tree;

/**
 * 二叉树
 * @author tangqing
 *
 */
public class BinaryTree {
	
	TreeNode root = null;
	
	public BinaryTree() {
		root = new TreeNode(1, "rootNode(A)");
	}
	
	/** 
     * 创建一棵二叉树 
     * <pre> 
     *           A 
     *     B          C 
     *  D     E            F 
     *  </pre> 
     */ 
	
	public void createBinTree(TreeNode root) {
		TreeNode nodeB = new TreeNode(2, "B");
		
		TreeNode nodeC = new TreeNode(3, "C");
		
		TreeNode nodeD = new TreeNode(4, "D");
		
		TreeNode nodeE = new TreeNode(5, "E");
		
		TreeNode nodeF = new TreeNode(6, "F");
		
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;
	}
	
	public boolean isEmtry(){
		return root == null;
	}
	
	/**
	 * 高度
	 * @return
	 */
	public int height(){
		return height(root);
	}
	
	/**
	 * 节点个数
	 * @return
	 */
	public int size(){
		return size(root);
	}
	
	/**
	 * 获取节点的父节点(双亲节点)
	 * @param node
	 * @return
	 */
	public TreeNode parent(TreeNode node){
		return (root == null || root == node) ? null : parent(root, node);
	}
	
	private TreeNode parent(TreeNode subTree, TreeNode node) {
		if(subTree == null) return null;
		if(subTree.leftChild == node || subTree.rightChild == node) return subTree;
		TreeNode p;
		if((p = parent(subTree.leftChild, node)) != null){
			return p;
		} else {
			return parent(subTree.rightChild, node);
		}
	}

	private int size(TreeNode subTree) {
		if(subTree == null) return 0;
		else return 1 + size(subTree.leftChild) + size(subTree.rightChild);
	}
	
	

	private int height(TreeNode subTree) {
		if(subTree == null) return 0;
		else {
			int i = height(subTree.leftChild);
			int j = height(subTree.rightChild);
			return (i > j) ? (i + 1) : (j + 1);
		}
	}
	
	public void destroy(TreeNode subTree){
		if(subTree != null){
			destroy(subTree.leftChild);
			destroy(subTree.rightChild);
			
			subTree = null;
		}
	}
	
	/**
	 * 前根遍历
	 * @param node
	 */
	public void preOrder(TreeNode node){
		if(node != null){
			visted(node);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
		
	}
	
	/**
	 * 中根遍历
	 * @param node
	 */
	public void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.leftChild);
			visted(node);
			inOrder(node.rightChild);
		}
	}
	
	/**
	 * 后根遍历
	 * @param node
	 */
	public void postOrder(TreeNode node) {
		if(node != null){
			postOrder(node.rightChild);
			postOrder(node.leftChild);
			visted(node);
		}
	}
	
	
    public void visted(TreeNode subTree){  
        subTree.isVisted=true;  
        System.out.println("key:"+subTree.key+"--name:"+subTree.data);;  
    }  
	
}
