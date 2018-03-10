package _cache._result_cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 优点:
 1.良好的并发性

 缺点:
 1.两个线程计算出相同的结果-->先检查 后运行

 */
public class Memoizer3<A, V> implements Computable<A, V>{
	
	private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
	
	private final Computable<A, V> c;
	

	public Memoizer3(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public V compute(A arg) throws InterruptedException {
		Future<V> future = cache.get(arg);
		if(future == null) {
			Callable<V> callable = new Callable<V>() {

				@Override
				public V call() throws Exception {
					return c.compute(arg);
				}
			};
			FutureTask<V> futureTask = new FutureTask<>(callable);
			future = futureTask;
			cache.put(arg, future);
			futureTask.run();
		}
		try {
			return future.get();
		} catch (ExecutionException e) {
			throw new InterruptedException(e.getMessage());
		}
	}

}
