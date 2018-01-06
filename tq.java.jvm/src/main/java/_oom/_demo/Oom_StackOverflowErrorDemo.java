package _oom._demo;

import java.util.ArrayList;

public class Oom_StackOverflowErrorDemo {


    //-verbose:gc -Xms20M -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution

    public static void main(String[] args) {

		stackOf();
        System.err.println("testMian");
    }

    private static void stackOf() {
        double s;
        stackOf();
    }


}
