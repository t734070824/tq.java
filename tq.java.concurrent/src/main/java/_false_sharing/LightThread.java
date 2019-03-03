package _false_sharing;

/**
 * @author 734070824@qq.com
 * @date 2019/3/3 15:07
 */
public class LightThread extends Thread {
    private SharingLong[] shares;
    private int i;

    public LightThread(SharingLong[] shares, int i) {
        this.shares = shares;
        this.i = i;
    }


    @Override
    public void run() {
        for (int j = 0; j < 100000000; j++) {
            shares[i].v++;
        }
    }
}
