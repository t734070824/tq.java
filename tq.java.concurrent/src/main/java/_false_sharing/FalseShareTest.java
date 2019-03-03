package _false_sharing;

/**
 * @author 734070824@qq.com
 * @date 2019/3/3 14:59
 */
public class FalseShareTest  {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Beanchmark();
        }
    }

    private static void Beanchmark() throws InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();
        SharingLong[] shares = new SharingLong[size];
        for (int i = 0; i < size; i++) {
            shares[i] = new SharingLong();
        }

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new LightThread(shares, i);
        }

        for(Thread t : threads){
            t.start();
        }

        long start = System.currentTimeMillis();

        for(Thread t : threads){
            t.join();
        }

        long end = System.currentTimeMillis();
        System.err.printf("cost: %d ms", end-start);

    }

}