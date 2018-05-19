package _fastjson._list;

/**
 * @author 734070824@qq.com
 * @date 2018/5/18 11:09
 */
public class LinkedListVo {

    private String name;

    private LinkedListVo next;

    @Override
    public String toString() {
        return "LinkedListVo{" +
                "name='" + name + '\'' +
                ", next=" + next +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedListVo getNext() {
        return next;
    }

    public void setNext(LinkedListVo next) {
        this.next = next;
    }
}
