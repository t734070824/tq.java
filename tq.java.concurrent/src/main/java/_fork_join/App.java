package _fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author 734070824@qq.com
 * @date 2018/5/3 10:45
 */
public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        System.err.println(submit.get());
    }
}
