package _old.singleton.step1;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1.在多线程的情况下，单例容易出错
 * @author tangqing
 *
 */
public class ThreadPoolManager {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 150, 0, TimeUnit.SECONDS,  new SynchronousQueue<Runnable>());
		for (int i = 0; i < 500; i++) {
			executor.execute(new CreateChocolate());
		}
		//executor.shutdown();
	}

}

class CreateChocolate implements Runnable{

	@Override
	public void run() {
		while(true){
			System.err.println(ChocolateBoiler.getInstance());
		}
	}
	
}

