package _linked_list._singly;

public class SinglyLinkedList {

    private SinglyNote head;

    private SinglyNote tail;

    public void addNode(SinglyNote node){
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
        SinglyNote tmp = head;
        while (tmp != null){
            sb.append(tmp.value).append("-->");
            tmp = tmp.nextNode;
        }
        return  sb.toString();
    }

    public SinglyNote getHead() {
        return head;
    }

    public void setHead(SinglyNote head) {
        this.head = head;
    }

    public SinglyNote getTail() {
        return tail;
    }

    public void setTail(SinglyNote tail) {
        this.tail = tail;
    }
}
