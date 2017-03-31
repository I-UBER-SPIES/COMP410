public class DDasAVL<K extends Comparable<? super K>, D> {
	private AVLtree<K, D> root;

	public DDasAVL() {
		root = null;
	} // Constructor

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(K k, D d) {
		root = insert(root, k, d);
	}

	public D find(K k) {
		return find(root, k);
	}

	public void remove(K k) {
		root = remove(root, k);
	}

	public int height() {
		return height(root);
	}// Not relevant to DD's -- used for comparing performance with AVL trees

	private AVLtree<K, D> insert(AVLtree<K, D> t, K k, D d) {
		
		if(root == null){
			root = new AVLtree<K, D>(k, d);
		}
		int compareKey = t.key.compareTo(k);
		if(compareKey < 0){ // < 0 means k is < t.key
			t.left = insert(t.left,k, d);
		}else if(compareKey > 0){
			t.right = insert(t.right,k,d);
		}else;
		
		return balance(root);
	} // Complete this

	private D find(AVLtree<K,D> t, K k){
		while(t!=null){
			int compareKey = k.compareTo(t.key);
			if(compareKey < 0){
				t = t.left;
			}
			else if(compareKey > 0){
				t = t.right;
			}
			if(compareKey == 0){
				return t.data;
			}
		}
		
	} // Complete this

	private AVLtree<K,D> findMin(AVLtree<K,D> t){
		if(t==null) return t;
		while(t.left != null){
			t=t.left;
		}
		return t;
	}// Complete this

	private AVLtree<K,D> remove(AVLtree<K,D> t, K k){
		
	} // Implement using LAZY
														// DELETE!!

	private int height(AVLtree<K, D> t) {
		return (t == null) ? -1 : t.height;
	}

	private AVLtree<K, D> balance(AVLtree<K, D> t) {
		if (t == null)
			return t;
		if (height(t.left) - height(t.right) > 1)
			if (height(t.left.left) >= height(t.left.right))
				t = rotateLL(t); // do an LL rotation
			else
				t = rotateLR(t); // do an LR rotation
		else if (height(t.right) - height(t.left) > 1)
			if (height(t.right.right) >= height(t.right.left))
				t = rotateRR(t); // do an RR rotation
			else
				t = rotateRL(t); // do an RL rotation

		t.height = 1 + Math.max(height(t.left), height(t.right));
		return t;
	}

	private AVLtree<K,D> rotateLL(AVLtree<K,D> k2){
		
	} // Complete this

	private AVLtree<K,D> rotateLR(AVLtree<K,D> k2){
		
	} // Complete this

	private AVLtree<K,D> rotateRR(AVLtree<K,D> k2){
		
	} // Complete this

	private AVLtree<K,D> rotateRL(AVLtree<K,D> k2){
		
	} // Complete this

}