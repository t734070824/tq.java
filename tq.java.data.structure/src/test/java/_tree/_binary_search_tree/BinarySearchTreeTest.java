package _tree._binary_search_tree;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author 734070824@qq.com
 * @date 2018/2/26 19:35
 */
public class BinarySearchTreeTest {

    @Test
    public void add(){
        BinarySearchTree tree = new BinarySearchTree(100);
        for (int i = 0; i < 10; i++) {
            tree.addElement(new Random().nextInt(200));
        }
        tree.printTree();
    }


    @Test
    public void remove(){
        BinarySearchTree tree = new BinarySearchTree(100);
        tree.addElement(58);
        tree.addElement(85);
        tree.addElement(76);
        tree.addElement(90);
        tree.addElement(131);
        tree.addElement(165);
        tree.addElement(163);
        tree.addElement(171);
        tree.addElement(168);
        tree.addElement(169);
        tree.printTree();


//        tree.remove(58);
//        tree.printTree();


        tree.remove(171);
        tree.printTree();
    }

}