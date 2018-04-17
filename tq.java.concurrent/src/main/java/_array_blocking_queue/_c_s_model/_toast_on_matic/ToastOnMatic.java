package _array_blocking_queue._c_s_model._toast_on_matic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 自动面包机
 */
public class ToastOnMatic {
	public static void main(String[] args) {
		LinkedBlockingQueue<Toast> dryQueue = new LinkedBlockingQueue<>();
		LinkedBlockingQueue<Toast> butterQueue = new LinkedBlockingQueue<>();
		LinkedBlockingQueue<Toast> jamQueue = new LinkedBlockingQueue<>();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Toaster(dryQueue));
		service.execute(new Butter(dryQueue, butterQueue));
		service.execute(new Jammer(butterQueue, jamQueue));
		service.execute(new Eater(jamQueue));
		service.shutdown();
	}
}


