
public class AVLtree<K extends Comparable<? super K>, D> {

	public K key;
	public D data;
	public int height;
	// public AVLNode parent;
	public AVLtree<K,D> left;
	public AVLtree<K,D> right;

	public AVLtree(K k, D d) {
		key = k;
		data = d;
		this.height = 0;
		left = null;
		right = null;
	}

}
