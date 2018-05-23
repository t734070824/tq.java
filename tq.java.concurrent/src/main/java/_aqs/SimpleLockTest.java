package _aqs;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class SimpleLockTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}


	@Test
	public void test1() throws InterruptedException {
		final SimpleLock lock = new SimpleLock();
	    lock.lock();

	    for (int i = 0; i < 10; i++) {
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                lock.lock();
	                System.out.println(Thread.currentThread().getId() + " acquired the lock!");
	                lock.unlock();
	            }
	        }).start();
	        // 简单的让线程按照for循环的顺序阻塞在lock上
	        Thread.sleep(10000);
	    }

	    System.out.println("main thread unlock!");
	    lock.unlock();
	}
}
