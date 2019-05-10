package _oom._memory_leak;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2019/5/10 16:30
 */
public class StaticMemoryLeak {

    static List list = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            list.add(o);
            o = null;
        }
    }
}
