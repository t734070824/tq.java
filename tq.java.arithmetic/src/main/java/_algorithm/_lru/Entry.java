package _algorithm._lru;

public class Entry<K, V> {
    public Entry<K, V> pre;
    public Entry<K, V> next;
    public K key;
    public V value;
}
