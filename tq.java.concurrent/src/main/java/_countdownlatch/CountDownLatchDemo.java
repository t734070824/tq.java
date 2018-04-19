package _countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch类是一个同步计数器,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，计数器减1,
 * 计数器大于0 时，await()方法会阻塞程序继续执行
 * CountDownLatch如其所写，是一个倒计数的锁存器，当计数减至0时触发特定的事件。利用这种特性，可以让主线程等待子线程的结束。
 * 下面以一个模拟运动员比赛的例子加以说明。
 */
public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// 新建一个CountDownLatch，并指制定一个初始大小
	      final CountDownLatch countDownLatch = new CountDownLatch(3);

	      final int sleepSec1 = 10;
	      final int sleepSec2 = 100;
	      final int sleepSec3 = 100;
	     //thread1
	     //调用countDown方法，将计数减1
	      new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(sleepSec1);
				} catch (InterruptedException e) {
					//
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
					//
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
					//
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
