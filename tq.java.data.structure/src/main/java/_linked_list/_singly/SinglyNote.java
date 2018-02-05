package _linked_list._singly;

/**
 * 单向链表 节点
 */
public class SinglyNote {
    int value;
    SinglyNote nextNode;

    public SinglyNote(int value, SinglyNote nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
