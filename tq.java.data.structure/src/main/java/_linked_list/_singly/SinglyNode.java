package _linked_list._singly;

/**
 * 单向链表 节点
 */
public class SinglyNode {
    int value;
    SinglyNode nextNode;

    public SinglyNode(int value, SinglyNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
