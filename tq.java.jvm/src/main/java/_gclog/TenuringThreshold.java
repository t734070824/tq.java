package _gclog;

public class TenuringThreshold {

    private static final int _1M = 1024 * 1024;

    //-verbose:gc -Xms20M -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1M / 4];
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];

    }
}
