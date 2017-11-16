package _threadpoolexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {
	
	private Executor exec;
	private Semaphore semaphore;
	public BoundedExecutor(Executor exec, Semaphore semaphore) {
		super();
		this.exec = exec;
		this.semaphore = semaphore;
	}
	
	public void submiteTask(final Runnable runnable) throws InterruptedException {
		
		semaphore.acquire();
		
		try {
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						runnable.run();
					} finally {
						semaphore.release();
					}
				}
			});
		} catch (Exception e) {
			semaphore.release();
		}
		
	}
	

}
