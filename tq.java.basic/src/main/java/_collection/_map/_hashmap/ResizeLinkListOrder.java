package _collection._map._hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2019/6/12 20:26
 */
public class ResizeLinkListOrder {

    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0; i < 18; i++) {
            map.put(new Node(1), i);
        }

        System.err.println(map);
    }

    public static class Node{
        int num;

        public Node(int num) {
            this.num = num;
        }

        @Override
        public int hashCode() {
            return num;
        }
    }
}
