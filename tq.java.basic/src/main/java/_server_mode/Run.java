package _server_mode;

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Run {

    public static void main(String[] args) throws InterruptedException {


        RunThread runThread = new RunThread();
        runThread.start();;

        Thread.sleep(1000);

        runThread.setRunning(false);

        System.err.println("复制false");


    }
}
