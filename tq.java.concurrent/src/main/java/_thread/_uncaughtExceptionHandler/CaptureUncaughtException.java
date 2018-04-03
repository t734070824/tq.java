package _thread._uncaughtExceptionHandler;


import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool(new HandlerThreadFactory());
		service.execute(new ExceptionThread());
	}
}


