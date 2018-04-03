package _semaphore;

import java.util.concurrent.Semaphore;

/**
 * 多个线程循环输出-->Semaphore
 * @author tangqing
 *
 */
public class ThreeThreadLoopOrderOutputBySemaphore {
	
	int count = 0;
	static Semaphore SemaphoreA = new Semaphore(1);
	static Semaphore SemaphoreB = new Semaphore(1);
	static Semaphore SemaphoreC = new Semaphore(1);
	int size = 3;
	public static void main(String[] args) {
		ThreeThreadLoopOrderOutputBySemaphore s = new ThreeThreadLoopOrderOutputBySemaphore();
		new Thread(s.new SemaphoreThread(0, SemaphoreA, SemaphoreB, "A")).start();
		new Thread(s.new SemaphoreThread(0, SemaphoreB, SemaphoreC, "B")).start();
		new Thread(s.new SemaphoreThread(0, SemaphoreC, SemaphoreA, "C")).start();
	}
	
	
	class SemaphoreThread implements Runnable{
		
		int order;
		Semaphore need;
		Semaphore release;
		String out;
		
		
		public SemaphoreThread(int order, Semaphore need, Semaphore release, String out) {
			this.order = order;
			this.need = need;
			this.release = release;
			this.out = out;
		}


		@Override
		public void run() {
			try {
				while (true) {
					if(count % size == order){
						need.acquire();
						System.err.println(out);
						count++;
					}
					release.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

