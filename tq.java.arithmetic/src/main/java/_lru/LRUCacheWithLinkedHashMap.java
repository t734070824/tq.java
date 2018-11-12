package _lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCacheWithLinkedHashMap<K, V> {
	
	private final int MAX_CACHE_SIZE;
	
	private final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	LinkedHashMap<K, V> cache;
	
	public LRUCacheWithLinkedHashMap(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		//根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        //向上取整
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        cache = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTOR, true) {
			private static final long serialVersionUID = 1149429885235855423L;
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
				return size() > MAX_CACHE_SIZE;
			}
        };
	}
	
	public synchronized void put(K k, V v) {
		cache.put(k, v);
	}
	
    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized void remove(K key) {
    	cache.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return cache.entrySet();
    }

    public synchronized int size() {
        return cache.size();
    }

    public synchronized void clear() {
    	cache.clear();
    }

    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
