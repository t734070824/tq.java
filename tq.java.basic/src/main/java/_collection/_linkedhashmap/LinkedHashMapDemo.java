package _collection._linkedhashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedHashMap = new RemovelinkedHashMap<Integer, String>(10, 0.75f, true);
		
		for (int i = 0; i < 11; i++) {
			linkedHashMap.put(i, i+"");
		}
		
		System.err.println(linkedHashMap);
		
	}

}

class RemovelinkedHashMap<K, V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 2732831837152918824L;
	
	public RemovelinkedHashMap(int i, float f, boolean b) {
		super(i, f, b);
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > 10;
	}
	
}
