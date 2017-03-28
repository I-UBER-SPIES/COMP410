
public class AVLtree<K extends Comparable<? super K>, D> {

	public K element;
	public int height;
	// public AVLNode parent;
	public AVLtree<K,D> left;
	public AVLtree<K,D> right;

	public AVLtree(K element) {
		this.element = element;
		this.height = 0;
		left = null;
		right = null;
	}

}
