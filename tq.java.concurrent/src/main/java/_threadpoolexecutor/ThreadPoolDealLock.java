package _threadpoolexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 如果提交的任务依赖与其他任务,除非线程池无限大,否则可能造成死锁
 * @author CTWLPC
 *
 */
public class ThreadPoolDealLock {
	
	ExecutorService exec = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolDealLock dealLock = new ThreadPoolDealLock();
		System.err.println(dealLock.getName());
		dealLock.exec.shutdown();
	}
	
		
	    private AtomicInteger index = new AtomicInteger();
		
	    public class Task implements Callable<String>{

	        public String call() throws Exception{
	            return getName();
	        }
	    }
		
	    public String service() throws InterruptedException, ExecutionException{
	        Future<String> future=exec.submit(new Task());
	        return future.get();
	    }
		
	    public String getName() throws InterruptedException, ExecutionException{
	        if(index.getAndIncrement() >= 0){
	            return service();
	        }
	        return "hello world";
	    }

}
