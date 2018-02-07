package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 二分搜索树
 * 假设所有的元素都不相同
 * 左节点 < 父节点 < 右节点
 * @author tangqing
 * @param <V>
 *
 */
public class BinarySearchTree<V extends Comparable<V>> {
	
	private TreeNode<V> root;
	
	public BinarySearchTree(V v) {
		root = new TreeNode<V>(v);
	}
	
	public void addElement(V element){
		TreeNode<V> node = new TreeNode<V>(element);
		TreeNode<V> parent = null;
		TreeNode<V> _root = root;
		while (true) {
			if(_root == null) break;
			parent = _root;
			if(_root.v.compareTo(node.v) > 0){
				_root = _root.leftChild;
			} else {
				_root = _root.rightChild;
			}
		}
		if(parent != null){
			if(node.v.compareTo(parent.v) < 0){
				parent.leftChild = node;
			} else {
				parent.rightChild = node;
			}
		}
	}
	
	//TODO 删除
	
	/**
	 * LDR 遍历
	 * @param rootNode
	 */
	public void LDRTraversal(TreeNode<V> rootNode){
		if(rootNode == null) return;
		else {
			LDRTraversal(rootNode.leftChild);
			System.err.print(rootNode.v + ",");
			LDRTraversal(rootNode.rightChild);
		}
	}
	
	/**
	 * DLR 遍历
	 * @param rootNode
	 */
	public void DLRTraversal(TreeNode<V> rootNode){
		if(rootNode == null) return;
		else {
			System.err.print(rootNode.v + ",");
			DLRTraversal(rootNode.leftChild);
			DLRTraversal(rootNode.rightChild);
		}
	}
	
	/**
	 * LRD 遍历
	 * @param rootNode
	 */
	public void LRDTraversal(TreeNode<V> rootNode){
		if(rootNode == null) return;
		else {
			LRDTraversal(rootNode.leftChild);
			LRDTraversal(rootNode.rightChild);
			System.err.print(rootNode.v + ",");
		}
	}
	
	public TreeNode<V> search(V element){
		if(root == null) return null;
		TreeNode<V> _root = root;
		while (true) {
			if(_root == null) break;
			if(root.v.equals(element)){
				return root;
			} else if(element.compareTo(_root.v) < 0) {
				_root = _root.leftChild;
			} else {
				_root = _root.rightChild;
			}
			
		}
		return null;
	}
	
	
	
	public void printTree(){
        if(root == null)
            return;
        Queue<TreeNode<V>> queue = new LinkedList<>();
        
        int current;//当前层 还未打印的结点个数
        int next;//下一层结点个数
        
        queue.offer(root);
        current = 1;
        next = 0;
        while(!queue.isEmpty()){
        	TreeNode<V> currentNode = queue.poll();
            System.out.printf("%-4d", currentNode.v);
            current--;
            
            if(currentNode.leftChild != null){
                queue.offer(currentNode.leftChild);
                next++;
            }
            if(currentNode.rightChild != null){
                queue.offer(currentNode.rightChild);
                next++;
            }
            if(current ==0){
                System.out.println();
                current = next;
                next = 0;
            }
        }
	}
	
	
	
	public TreeNode<V> getRoot(){
		return root;
	}
	
	
	private class TreeNode<V>{
		public V v;
		
		
		public TreeNode<V> leftChild;
		
		public TreeNode<V> rightChild;
		
		public TreeNode(V v) {
			this.v = v;
		}
		
		@Override
		public String toString() {
			return leftChild.v + "---" + v + "---" + rightChild.v;
		}
	}
}
