package _cache._result_cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 缺点:当某个计算时间过长的时候,会有多次计算相同值的情况出现
 * @author tangqing
 *
 * @param <A>
 * @param <V>
 */
public class Memoizer2<A, V> implements Computable<A, V> {
	
	
	private final Map<A, V> cache = new ConcurrentHashMap<>();
	
	private final Computable<A, V> c;

	public Memoizer2(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if(result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}
