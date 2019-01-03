package _book._algorithms_4th_edition._3_search._3_3_balanced_search_trees._avl_tree;

import org.junit.Test;

/**
 * @author 734070824@qq.com
 * @date 2019/1/3 15:19
 */
public class AvlTreeTest {

    @Test
    public void insert(){
        int[] arr = new int[]{5, 7,3,4,10, 11, 12};
        AVLTree tree = new AVLTree(6);
        for (int i : arr) {
            tree.insert(tree.root, i);
        }
        System.err.println("123");
    }
}
