package _interrupt;

public class Run3 {

    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread();
            thread.start();

            Thread.sleep(1000);

            thread.interrupt();

            System.err.println("1 = " + (thread.isInterrupted()));
            System.err.println("2 = " + (thread.isInterrupted()));


        } catch (InterruptedException e){
            System.err.println("main catch");
            e.printStackTrace();
        }

        System.err.println("end !");
    }
}
