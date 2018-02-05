package _linked_list._singly;

import org.junit.Test;

public class App {

    @Test
    public void common(){
        SinglyLinkedList singlyLinkedList = SinglyUtil.init(10);

        System.err.println(singlyLinkedList.toString());


        singlyLinkedList.addNode(new SinglyNote(1231,null));

        System.err.println(singlyLinkedList.toString());
    }

    @Test
    public void reverse(){
        SinglyLinkedListWithReverse singlyLinkedList = SinglyUtil.initWithReverse(10);
        System.err.println(singlyLinkedList.toString());

        singlyLinkedList.reverse();

        System.err.println(singlyLinkedList.toString());
    }

}
