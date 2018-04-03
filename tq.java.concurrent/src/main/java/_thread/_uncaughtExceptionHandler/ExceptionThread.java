package _thread._uncaughtExceptionHandler;

public class ExceptionThread implements Runnable{

	public void run() {
		throw new RuntimeException();
	}
	}
