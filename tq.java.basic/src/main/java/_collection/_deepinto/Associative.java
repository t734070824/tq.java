package _collection._deepinto;

/**
 * 组合
 * @param <K>
 * @param <V>
 */
public class Associative<K,V> {
	private Object[][] pairs;
	private int index;
	
	public Associative(int length) {
		pairs = new Object[length][2];
	}
	
	public void put(K key, V value){
		if(index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[]{key, value};
	}
	
	@SuppressWarnings("unchecked")
	public V gen(K key){
		for (int i = 0; i < pairs.length; i++) {
			if(key == pairs[i][0])
				return (V) pairs[i][1];
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pairs.length; i++) {
			sb.append(pairs[i][0].toString())
			  .append(":")
			  .append(pairs[i][1])
			  .append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Associative<String, String> map = new Associative<>(6);
		map.put("1", "a");
		map.put("1", "a");
		map.put("1", "a");
		map.put("1", "a");
		map.put("1", "a");
		map.put("1", "a");
		System.err.println(map);
	}
	
}
