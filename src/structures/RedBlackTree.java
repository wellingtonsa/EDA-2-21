package structures;

public class RedBlackTree<K extends Comparable<K>, V> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	protected Node root;
	
	protected class Node {
		K key;
		V value;
		Node left;
		Node right;
		int count;
		
		public Node(K key, V value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}	
	}
	
	private class RBNode extends Node {
		boolean color; 
		
		public RBNode(K key, V value, int count) {
			super(key, value, count);
			color = RED;
		}
	}
	
	public void put(K key, V value) {
		root = put(root, key, value);
		setColor(root, BLACK);
	}
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new RBNode(key, value, 1); 
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		
		if (!isRed(r.left) && isRed(r.right)) r = rotateLeft(r);
		if (isRed(r.left) && isRed(r.left.left)) r = rotateRight(r);
		if (isRed(r.left) && isRed(r.right)) flipColors(r);
		
		return r;
	}
	
	public V get(K key) {
		Node r = root;
		while (r != null) {
			int cmp = key.compareTo(r.key);
			if (cmp < 0) r = r.left;
			else if (cmp > 0) r = r.right;
			else return r.value;
		}
		return null;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node r) {
		return (r != null)? r.count : 0;
	}

	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node delete(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = delete(r.left, key);
		else if (cmp > 0) r.right = delete(r.right, key);
		else {
			if (r.left == null) return r.right;
			else if (r.right == null) return r.left;
			Node tmp = r;
			r = min(r.right);
			r.left = tmp.left;
			r.right = deleteMin(tmp.right);
		}
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}
	
	public K min() {
		Node min = min(root);
		return min.key;
	}
	
	private Node min(Node r) {
		if (r.left == null) return r;
		return min(r.left);
		
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node r) {
		if (r.left == null) return r.right;
		r.left = deleteMin(r.left);
		r.count = size(r.right) + size(r.left) + 1;
		return r;
	}
	

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		setColor(x, getColor(h));
		setColor(h, RED);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		setColor(x, getColor(h));
		setColor(h, RED);
		return x;
	}
	
	private void flipColors(Node h) {
		setColor(h, RED);
		setColor(h.left, BLACK);
		setColor(h.right, BLACK);
	}
	
	@SuppressWarnings("unchecked")
	private void setColor(Node n, boolean color) {
		RBNode node = (RBNode) n;
		node.color = color;
	}
	
	@SuppressWarnings("unchecked")
	private boolean getColor(Node n) {
		RBNode node = (RBNode) n;
		return node.color;
	}
	
	private boolean isRed(Node n) {
		if (n == null) return false;
		return getColor(n) == RED;
	}
	
	public void inOrder() {
		this.inOrder(root);
	}
	
	
	private void inOrder(Node node) {
	    if(node != null){
	    	inOrder(node.left);
	      	System.out.println(node.value);
	      	inOrder(node.right);
	    }
	}
	

}