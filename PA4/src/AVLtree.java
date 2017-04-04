
public class AVLtree<K extends Comparable<? super K>, D> {

	public K key;
	public D data;
	public int height;
	// public AVLNode parent;
	public AVLtree<K,D> left;
	public AVLtree<K,D> right;
	boolean dead;

	public AVLtree(K k, D d, AVLtree<K, D> l, AVLtree<K, D> r) {
        key = k;
        data = d;
        left = l;
        dead = false;
        height = 0;
    }

}
