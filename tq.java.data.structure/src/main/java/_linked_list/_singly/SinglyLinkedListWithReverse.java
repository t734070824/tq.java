package _linked_list._singly;

public class SinglyLinkedListWithReverse extends SinglyLinkedList {

    public void reverse(){
        SinglyNote head = getHead();
        SinglyNote tail = getTail();
        SinglyNote nextNode = head.nextNode;
        if(head == null)
            throw  new NullPointerException("head is null");
        if(nextNode == null)
            throw  new NullPointerException("head.nextNode is null");
        if(tail == null)
            throw  new NullPointerException("tail is null");

        SinglyNote pre = head;
        SinglyNote cur = head.nextNode;
        SinglyNote next = null;
        while(cur != null){
            next = cur.nextNode;
            cur.nextNode = pre;

            pre = cur;
            cur = next;
        }
        head.nextNode = null;
        setHead(tail);
        setTail(head);

    }

}
