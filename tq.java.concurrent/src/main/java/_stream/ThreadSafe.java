package _stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 734070824@qq.com
 * @date 2019/4/30 9:16
 */
public class ThreadSafe {

    public static void main(String[] args) {
        List<Object> beans = new ArrayList<>();
        Map map = new HashMap();
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        map.entrySet().parallelStream().forEach((entry) -> {
            beans.add(entry);
        });

        System.err.println(beans.size());


        beans.clear();
        List collect = (List) map.entrySet().parallelStream().collect(Collectors.toList());
        System.err.println(collect.size());

    }
}
