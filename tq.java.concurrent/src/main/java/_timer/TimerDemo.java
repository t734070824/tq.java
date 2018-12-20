package _timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer
 * @author 734070824@qq.com
 * @date 2018/12/20 10:43
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        for (int i = 100; i >= 1; i--) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.err.println("132");
                }
            }, 100000*i);
        }

    }
}
