package _array_blocking_queue._c_s_model._toast_on_matic;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 黄油机
 */
public class Butter implements Runnable{

	private LinkedBlockingQueue<Toast> DRYQueue,BUTTERQUEUE;

	public Butter(LinkedBlockingQueue<Toast> DRYQueue, LinkedBlockingQueue<Toast> BUTTERQUEUE) {
		this.DRYQueue = DRYQueue;
		this.BUTTERQUEUE = BUTTERQUEUE;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = DRYQueue.take();
				t.butter();
				System.err.println(t);
				BUTTERQUEUE.put(t);
			}
		} catch (InterruptedException e) {
			System.err.println("butter interrupted");
		}
		System.err.println("butter off");
	}

}
