package _cpu;;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * cpu利用率计算工具
 * Created by will on 17-3-13.
 */
public class CpuUsageHandler {
    private Long cpuBefore = null;
    private Instant start = null;

    private final static Long ZERO_DEFAULT = 0L;

    private final static int MS_SLEEP = 150;

    private volatile static long currentRate = 0;


    /**
     * 获取当前cpu利用率
     * @return
     */
    public static long getCurrentRate(){
        return currentRate;
    }


    /**
     * 获取利用率
     * @return
     */
    private long workoutRate(){
        try {
            return  getCpuUsage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ZERO_DEFAULT;
    }

    public long getCpuUsage() throws Exception {
        double cpuUsed = 0;
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("top -b -n 1");// 调用系统的“top"命令
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str = null;
            String[] strArray = null;
            while ((str = in.readLine()) != null) {
                int m = 0;
                if (str.indexOf("PID") == -1
                        && (str.indexOf(" R ") != -1 || str.indexOf(" S ") != -1)
                        && str.indexOf("top") == -1) {// 只分析正在运行的进程，top进程本身除外
                    strArray = str.split(" ");
                    for (String tmp : strArray) {
                        if (tmp.trim().length() == 0)
                            continue;
                        if (++m == 9) {// 第9列为CPU的使用百分比(RedHat 9)
                            cpuUsed += Double.parseDouble(tmp);
                        }
                    }
                     System.out.println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return (long)(cpuUsed);
    }

    public static void main(String[] args) throws Exception {
        CpuUsageHandler cpu = new CpuUsageHandler();
        System.out.println("cpu used:" + cpu.getCpuUsage() + "%");
    }

}
