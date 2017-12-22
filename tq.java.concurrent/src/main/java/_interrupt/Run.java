package _interrupt;

public class Run {

    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread();
            thread.start();

            Thread.sleep(1000);

            thread.interrupt();
//            Thread.currentThread().interrupt();
            System.err.println("1 = " + (thread.interrupted()));
            System.err.println("2 = " + (thread.interrupted()));
        } catch (InterruptedException e){
            System.err.println("main catch");
            e.printStackTrace();
        }

        System.err.println("end !");
    }
}
