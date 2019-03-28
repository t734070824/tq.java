package _array_blocking_queue._c_s_model._toast_on_matic;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 果酱机
 */
public class Jammer implements Runnable{

	private LinkedBlockingQueue<Toast> BUTTERQUEUE,JAMQUEUE;

	public Jammer(LinkedBlockingQueue<Toast> BUTTERQUEUE, LinkedBlockingQueue<Toast> JAMQUEUE) {
		this.BUTTERQUEUE = BUTTERQUEUE;
		this.JAMQUEUE = JAMQUEUE;
	}


	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = BUTTERQUEUE.take();
				t.jam();
				System.err.println(t);
				JAMQUEUE.put(t);
			}
		} catch (InterruptedException e) {
			System.err.println("Jammer interrupted");
		}
		System.err.println("Jammer off");
	}

}
