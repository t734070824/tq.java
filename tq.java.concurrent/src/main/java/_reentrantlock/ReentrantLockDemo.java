package _reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				try {
					TimeUnit.SECONDS.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
                System.err.println("unlock");
			}
		},"sleep").start();

		TimeUnit.SECONDS.sleep(2);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				System.err.println(lock);
				lock.unlock();
			}
		}, "nosleep").start();
		
		
	}

}
