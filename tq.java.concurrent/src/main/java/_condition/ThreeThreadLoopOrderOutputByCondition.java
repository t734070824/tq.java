package _condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程循环输出-->condition
 * @author tangqing
 *
 */
public class ThreeThreadLoopOrderOutputByCondition {
	int count = 0;
	int sleepSec = 1;
	int size = 3;
	static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		ThreeThreadLoopOrderOutputByCondition o = new ThreeThreadLoopOrderOutputByCondition();
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();
		
		new Thread(o.new ThreadOutput(conditionA, conditionB, "AAAAAAAAAA", 0)).start();
		new Thread(o.new ThreadOutput(conditionB, conditionC, "BBBBBBBBBB", 1)).start();
		new Thread(o.new ThreadOutput(conditionC, conditionA, "CCCCCCCCCC", 2)).start();
	}
	
	class ThreadOutput implements Runnable{
		Condition me; 
		Condition next; 
		String out;
		int order;
		public ThreadOutput(Condition me, Condition next, String out, int order) {
			super();
			this.me = me;
			this.next = next;
			this.out = out;
			this.order = order;
		}
		
		@Override
		public void run() {
			lock.lock();
			try {
				while (true) {
					if(count % size != order) me.await();
					System.err.println(out);
					count++;
					next.signal();
					TimeUnit.SECONDS.sleep(sleepSec);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
	}
}

