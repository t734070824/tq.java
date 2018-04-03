package _thread._uncaughtExceptionHandler;

public class MyUncaughtException implements Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.err.println(e);
	}

}
