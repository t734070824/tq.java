package _tree._binary_search_tree;

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
	
	//如果结点为叶子结点（没有左、右子树），此时删除该结点不会破坏树的结构直接删除即可，并修改其父结点指向它的引用为null
	//如果其结点只包含左子树，或者右子树的话，此时直接删除该结点，并将其左子树或者右子树设置为其父结点的左子树或者右子树即可
	//当结点的左右子树都不空的时候，一般的删除策略是用其右子树的最小数据（容易找到）代替要删除的结点数据并递归删除该结点（此时为null），因为右子树的最小结点不可能有左孩子，所以第二次删除较为容易

    public void remove(V v) {
        remove(v,root);
    }

    public TreeNode<V> remove(V v,TreeNode<V> node){
	    if(node == null) return node;
        int result = v.compareTo(node.v);
        if(result > 0){
            node.rightChild = remove(v, node.rightChild);
        } else if(result < 0){
            node.leftChild = remove(v, node.leftChild);
        } else if(node.leftChild != null && node.rightChild != null){
            node.v = minData(node.rightChild);
            node.rightChild = remove(node.v, node.rightChild);
        } else {
            node = (node.leftChild != null) ? node.leftChild : node.rightChild;
        }
        return node;
    }


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


	public V maxData() {
		return maxData(root);
	}

	public V maxData(TreeNode<V> subTree) {
        V max = subTree.v;
		if(subTree.rightChild != null){
			max = maxData(subTree.rightChild);
		}
		return max;
	}
	public V minData() {
		return minData(root);
	}

	public V minData(TreeNode<V> subTree) {
        V min = subTree.v;
        if(subTree.leftChild != null){
			min = minData(subTree.leftChild);
		}
		return min;
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
			return (leftChild != null ? leftChild.v+"":"null") +
                    "---" + v + "---" +
                    (rightChild != null ? rightChild.v + "" : "null");
		}
	}
}
