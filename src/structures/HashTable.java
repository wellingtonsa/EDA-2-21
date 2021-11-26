package structures;

public class HashTable<K, V>{
	
	int m;
	
	private K[] keys;
	private V[] values;
	
	public HashTable() {
		this(97);
	}

	@SuppressWarnings("unchecked")
	public HashTable(int m) {
		this.m = m;
		this.keys = (K[]) new Object[m];
		this.values = (V[]) new Object[m];
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	public void put(K key, V value) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i])) i = (i + 1) % m;
		keys[i] = key;
		values[i] = value; 
	}

	public V get(K key) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i])) i = (i + 1) % m;
		return values[i];
	}

}
