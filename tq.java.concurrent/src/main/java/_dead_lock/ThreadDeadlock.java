package _dead_lock;

import java.util.concurrent.*;

/**
 * ThreadDeadlock
 * Task that deadlocks in a single-threaded Executor
 * 线程饥饿死锁
 * 解决方式:线程池足够大
 * @author Brian Goetz and Tim Peierls
 */
public class ThreadDeadlock {
//	ThreadPoolExecutor exec = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

    ExecutorService exec = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, InterruptedException {
        ThreadDeadlock lock = new ThreadDeadlock();
        Future<String> result = lock.exec.submit(lock.new RenderPageTask());
        try {
            System.out.println("last result:"+result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally{
            lock.exec.shutdown();
        }
    }

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        public String call() throws Exception {
            // Here's where we would actually read the file
        	System.err.println(fileName);
            return "";
        }
    }

    public class RenderPageTask implements Callable<String> {
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // Will deadlock -- task waiting for result of subtask
//            return header.get(1, TimeUnit.SECONDS) + page + footer.get(1, TimeUnit.SECONDS);
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            // Here's where we would actually render the page
        	System.err.println("renderBody");
            return "";
        }
    }
}
