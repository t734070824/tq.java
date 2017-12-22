package _interrupt;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if(i % 100000 == 0)
             System.err.println("i==" + (i + 1));
        }
    }
}
