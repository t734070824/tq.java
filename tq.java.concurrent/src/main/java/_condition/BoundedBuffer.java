package _condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent.ArrayBlockingQueue的功能
 * @author CTWLPC
 *
 */
public class BoundedBuffer {
	
	final ReentrantLock lock = new ReentrantLock();//锁对象
	final Condition notFull = lock.newCondition();//写锁
	final Condition notEmpty = lock.newCondition();//读锁
	
	final Object[] items = new Object[100];
	
	int putIndex;//写索引
	int takeIndex;//读索引
	int count;//队列中的数量
	
	public void put (Object o) throws InterruptedException {
		lock.lock();
		try {
			while(count == items.length) {
				notFull.await();
			}
			
			//写入队列 更新索引
			items[putIndex] = o;
			putIndex++;
			if(putIndex == items.length) putIndex = 0;
			count++;
			notEmpty.signal();
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (items.length == 0) {
				notEmpty.await();
			}
			
			Object o = items[takeIndex];
			takeIndex++;
			if(takeIndex == items.length) takeIndex = 0;
			--count;
			notFull.signal();
			return o;
		} finally {
			lock.unlock();
		}
	}

}
