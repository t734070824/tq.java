package _oom._permgen_space;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=5M  -XX:MaxPermSize=5M -Xms100M -Xmx100M
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
