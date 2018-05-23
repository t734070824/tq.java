package _lock;

import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/5/23 17:36
 */
public class MCSLockApp {

    public static void main(String[] args) throws InterruptedException {
        MCSLock lock = new MCSLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MCSLock.MCSNode mcsNode = new MCSLock.MCSNode();
                lock.lock(mcsNode);
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock(mcsNode);

            }
        }).start();

        TimeUnit.SECONDS.sleep(10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                MCSLock.MCSNode mcsNode = new MCSLock.MCSNode();
                lock.lock(mcsNode);
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock(mcsNode);
            }
        }).start();
    }
}
