package _cache._result_cache;

public interface Computable<A, V> {
	
	V compute(A arg) throws InterruptedException;

}
