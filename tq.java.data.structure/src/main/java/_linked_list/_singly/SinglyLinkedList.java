package _linked_list._singly;

public class SinglyLinkedList {

    private SinglyNode head;

    private SinglyNode tail;

    public void addNode(SinglyNode node){
        if(node == null)
            throw  new NullPointerException("node is null");
        if(head == null){
            head = node;
            return;
        }

        if(head.nextNode == null){
            tail = node;
            head.nextNode = tail;
            return;
        }
        tail.nextNode = node;
        tail = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SinglyNode tmp = head;
        while (tmp != null){
            sb.append(tmp.value).append("-->");
            tmp = tmp.nextNode;
        }
        return  sb.toString();
    }

    public SinglyNode getHead() {
        return head;
    }

    public void setHead(SinglyNode head) {
        this.head = head;
    }

    public SinglyNode getTail() {
        return tail;
    }

    public void setTail(SinglyNode tail) {
        this.tail = tail;
    }
}
