package _lru;

import java.util.HashMap;

public class LRUCache<K, V> {
	
	private final int MAX_CACHE_SIZE;
	
	private Entry<K, V> first;
	
	private Entry<K, V> last;
	
	private HashMap<K, Entry<K, V>> hashMap;
	
	public LRUCache(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		hashMap = new HashMap<>();
	}
	
	public void put(K k, V v) {
		Entry<K, V> entry = getEntry(k);
		if(entry == null) {
			if(hashMap.size() >= MAX_CACHE_SIZE) {
				removeLast();
			}
			entry = new Entry<K, V>();
			entry.key = k;
		}
		entry.value = v;
		moveToFirst(entry);
		hashMap.put(k, entry);
	}
	
	public V get(K k) {
		Entry<K, V> entry = getEntry(k);
		if(entry == null) return null;
		moveToFirst(entry);
		return entry.value;
	}
	
	public void remove(K k) {
		Entry<K, V> entry = getEntry(k);
		if(entry != null) {
			if(entry.pre != null) entry.pre.next = entry.next;
			if(entry.next != null) entry.next.pre = entry.pre;
			if(entry == first) first = entry.next;
			if(entry == last) last = entry.pre;
		}
		hashMap.remove(k);
	}

	private void moveToFirst(Entry<K, V> entry) {
		if(entry == first) return;
		if(entry.pre != null) {
			entry.pre.next = entry.next;
		}
		if(entry.next != null) { 
			entry.next.pre = entry.pre; 
		}
		if(entry == last) last = last.pre;
		
		if(first == null || last == null) {
			first = last = null;
		}
		entry.next = first;
		first.pre = entry;
		first = entry;
		entry.pre = null;
	}

	private void removeLast() {
		if(last != null) {
			last = last.pre;
			if(last == null) first = null;
			else last.next = null;
			hashMap.remove(last.key);
		}
	}

	private Entry<K, V> getEntry(K k) {
		return hashMap.get(k);
	}
}

class Entry<K, V> {
    public Entry<K, V> pre;
    public Entry<K, V> next;
    public K key;
    public V value;
}
