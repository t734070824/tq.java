package _linked_list._singly;

public class SinglyUtil {

    public static SinglyLinkedList init(int num){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 0; i < num; i++) {
            singlyLinkedList.addNode(new SinglyNote(i, null));
        }
        return  singlyLinkedList;
    }

    public static SinglyLinkedListWithReverse initWithReverse(int num){
        SinglyLinkedListWithReverse singlyLinkedList = new SinglyLinkedListWithReverse();
        for (int i = 0; i < num; i++) {
            singlyLinkedList.addNode(new SinglyNote(i, null));
        }
        return  singlyLinkedList;
    }

}
