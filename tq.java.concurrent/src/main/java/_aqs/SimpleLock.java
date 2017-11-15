package _aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleLock extends AbstractQueuedSynchronizer{

	private static final long serialVersionUID = -6174931851825201541L;
	
	
	public SimpleLock() {

	}
	
	
	@Override
	protected boolean tryAcquire(int arg) {
		if(compareAndSetState(0, 1)) {
			setExclusiveOwnerThread(Thread.currentThread());
			return true;
		}
		return false;
	}
	
	
	@Override
	protected boolean tryRelease(int arg) {
		setExclusiveOwnerThread(null);
		setState(0);
		return true;
	}
	
	public void lock() {
		acquire(1);
	}
	
	public boolean tryLock() {
		return tryAcquire(1);
	}
	
	public void unlock() {
		release(1);
	}
	
	public boolean isLocked() {
		return isHeldExclusively();
	}
	
	
	

}
