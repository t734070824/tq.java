package _array_blocking_queue._c_s_model._toast_on_matic;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 烤箱
 */
public class Toaster implements Runnable{

	private LinkedBlockingQueue<Toast> DRYQueue;

	private int count;

	private Random r = new Random(47);

	public Toaster(LinkedBlockingQueue<Toast> queue) {
		this.DRYQueue = queue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(200 + r.nextInt(500));
				Toast toast = new Toast(count++);
				System.err.println(toast);
				DRYQueue.put(toast);

			}
		} catch (InterruptedException e) {
			System.err.println("Toster interrupted");
		}
		System.err.println("Toaster off");
	}

}
