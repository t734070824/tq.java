package _future._future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * futureTask 研究
 * @author 734070824@qq.com
 * @date 2018/12/26 14:16
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws InterruptedException {
        FutureTask task = new FutureTask(new Task());
        Thread thread = new Thread(task);
        thread.setName("Task thread");
        thread.start();

        for (int i = 0; i < 3; i++) {
            Thread getThread = new Thread(new GetResult(task));
            getThread.setName("getResult thread");
            getThread.start();

            TimeUnit.SECONDS.sleep(20);
        }




    }


    // 1. 继承Callable接口,实现call()方法,泛型参数为要返回的类型
    static class Task  implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");
            int result = 0;
            for(int i = 0; i < 100;++i) {
                result += i;
            }

            TimeUnit.SECONDS.sleep(1000);
            return result;
        }
    }


    static class GetResult  implements Runnable{

        private FutureTask task;

        public GetResult(FutureTask task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                Object o = task.get();
                System.err.println(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
