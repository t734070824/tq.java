package _interrupt;

public class Run2 {

    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread();
            thread.start();

            Thread.sleep(1000);
            Thread.currentThread().interrupt();
            System.err.println("1 = " + (thread.interrupted()));
            System.err.println("2 = " + (thread.interrupted()));
        } catch (InterruptedException e){
            System.err.println("main catch");
            e.printStackTrace();
        }

        System.err.println("end !");
    }
}
