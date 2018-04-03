package _thread._uncaughtExceptionHandler;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		System.err.println(this + "  start");
		Thread t = new Thread(r);
		System.err.println("creat  " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtException());
		return t;
	}

}
