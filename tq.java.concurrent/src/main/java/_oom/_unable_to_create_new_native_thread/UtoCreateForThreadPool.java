package _oom._unable_to_create_new_native_thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UtoCreateForThreadPool extends AbsThreadPool{
	
	public static void main(String[] args) {
		int num = 0;
		while (true) {
			System.err.println("num = " + num);
			UtoCreateForThreadPool pool = new UtoCreateForThreadPool();
			num++;
		}
	}
	
	

}


abstract class  AbsThreadPool{
	
	public ThreadPoolExecutor executor;
	public AbsThreadPool() {
		init();
	}
	
	public void init() {
		executor = new ThreadPoolExecutor(6, 6, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        executor.prestartAllCoreThreads();
	}
}
