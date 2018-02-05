package _linked_list._singly._reverse;

import _linked_list._singly.SinglyLinkedList;
import _linked_list._singly.SinglyNote;

public class SinglyLinkedListWithReverse extends SinglyLinkedList {

    public void reverse(){
        SinglyNote head = getHead();
        SinglyNote tail = getTail();
        if(head == null)
            throw  new NullPointerException("head is null");
        if(tail == null)
            throw  new NullPointerException("tail is null");
        reverse(head);
    }

    public void reverse(SinglyNote node) {
        if(node == null)
            throw  new NullPointerException("head is null");
    }
}
