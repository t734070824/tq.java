package _linked_list._singly;

/**
 * 反转链表
 */
public class SinglyLinkedListWithReverse extends SinglyLinkedList {

    public void reverse(){
        SinglyNode head = getHead();
        SinglyNode tail = getTail();
        SinglyNode nextNode = head.nextNode;
        if(head == null)
            throw  new NullPointerException("head is null");
        if(nextNode == null)
            throw  new NullPointerException("head.nextNode is null");
        if(tail == null)
            throw  new NullPointerException("tail is null");

        SinglyNode pre = head;
        SinglyNode cur = head.nextNode;
        SinglyNode next = null;
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
