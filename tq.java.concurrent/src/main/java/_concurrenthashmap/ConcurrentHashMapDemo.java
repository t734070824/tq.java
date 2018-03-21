package _concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 源码
 * @author 734070824@qq.com
 * @date 2018/3/13 17:56
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<String, String>();
        for (int i = 0; i < 50; i++) {
            if(i == 11){
                //扩容
                System.err.println("debug");
            }
            cm.put("key_" + i, "tangqing_" + i);
        }
    }
}
