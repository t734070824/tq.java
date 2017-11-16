package _reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock(true);
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				try {
					TimeUnit.SECONDS.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
			}
		},"sleep").start();
		
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
