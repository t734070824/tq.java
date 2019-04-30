package _oom._demo;

import java.util.ArrayList;

public class Oom_JavaHeapSpace {

    //-verbose:gc -Xms20M -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
    //-Xmx10m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        oom();
    }

    private static void oom() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(true){
            list.add(1);
        }
    }
}
