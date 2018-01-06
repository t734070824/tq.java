package _oom._demo;

import java.util.ArrayList;
import java.util.List;

public class FillHeapDemo {
    public static void  fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    //-Xms100m -Xmx100m -XX:+UseSerialGC
    public static void main(String[] args) throws InterruptedException {
        fillHeap(2000);
    }

    static class OOMObject{
        public byte[] placeholder = new byte [64 * 1024];
    }
}
