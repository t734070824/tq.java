package _collection._map._hashmap;

import java.util.HashMap;

/**
 * @author 734070824@qq.com
 * @date 2018/12/17 17:30
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put(0, "0");
        for (int i = 0; i < 1000; i++) {
            map.put(i+"", i);
        }

        for (int i = 0; i < 1000; i++) {
            map.get(i+"");
        }
    }
}
