package _example._cache;

import java.util.HashMap;
import java.util.Map;


/**
 * 缺点:阻塞时间过长
 * @author tangqing
 *
 * @param <A>
 * @param <V>
 */
public class Memoizer<A, V> implements Computable<A, V> {
	
	
	private final Map<A, V> cache = new HashMap<A, V>();
	
	private final Computable<A, V> c;

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if(result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}
