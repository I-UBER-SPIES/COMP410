
public class AVLtree<K extends Comparable<? super K>, D> {

	public K key;
	public D data;
	public int height;
	// public AVLNode parent;
	public AVLtree<K,D> left;
	public AVLtree<K,D> right;
	boolean active;

	public AVLtree(K k, D d) {
		key = k;
		data = d;
		height = 0;
		left = null;
		right = null;
		active = true;
	}

}
