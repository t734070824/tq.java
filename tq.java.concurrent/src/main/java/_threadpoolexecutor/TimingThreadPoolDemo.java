package _threadpoolexecutor;

import java.util.concurrent.TimeUnit;

/**
 * 主要是测试 到底是谁调用了beforeExecute 是主线程 还是 任务线程 --> 任务线程 ThreadFactory.newThread().start();--> Worker
 * @author CTWLPC
 *
 */
public class TimingThreadPoolDemo {
	
	public static void main(String[] args) {
		TimingThreadPool pool = new TimingThreadPool();
		
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
