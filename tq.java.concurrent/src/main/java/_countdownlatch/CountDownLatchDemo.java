package _countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// 新建一个CountDownLatch，并指制定一个初始大小
	      final CountDownLatch countDownLatch = new CountDownLatch(3);

	      final int sleepSec1 = 10;
	      final int sleepSec2 = 10;
	      final int sleepSec3 = 10;
	     //thread1
	     //调用countDown方法，将计数减1
	      new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(sleepSec1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}
		}, "sleep1").start();


	     //thread2
	     // do something 
	     //...........
	     //调用countDown方法，将计数减1
	      new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(sleepSec2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}
		}, "sleep2").start();

	       //thread3
	     // do something 
	     //...........
	     //调用countDown方法，将计数减1
	      new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(sleepSec3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}
		}, "sleep3").start();
	      
	      
	      // 调用await方法后，main线程将阻塞在这里，直到countDownLatch 中的计数为0 
	      countDownLatch.await();
	      System.out.println("over");
	}

	
	
}
