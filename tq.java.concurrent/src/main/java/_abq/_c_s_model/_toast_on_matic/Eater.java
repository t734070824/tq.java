package _abq._c_s_model._toast_on_matic;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 时刻
 */
public class Eater implements Runnable{

	private LinkedBlockingQueue<Toast> JAMQUEUE;

	private int count;

	public Eater(LinkedBlockingQueue<Toast> JAMQUEUE) {
		this.JAMQUEUE = JAMQUEUE;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = JAMQUEUE.take();
				if(t.getId() != count++ || t.getStatus() != Toast.Status.JAMMED){
					System.err.println("Error:" + t);
					System.exit(1);
				} else {
					System.err.println("chomp :" + t);
				}

			}
		} catch (InterruptedException e) {
			System.err.println("eater interrupted");
		}
		System.err.println("eat off");
	}

}
