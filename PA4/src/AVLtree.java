
public class AVLtree<K extends Comparable<? super K>, D> {
	private final static int ALLOWED_IMBALANCE = 1;
	private AVLNode root;
	private int size;
	private int sizeOfRightSubtree;

	public AVLtree() {
		root = null;
		size = 0;
		sizeOfRightSubtree = 0;
	}
	
	

	public void insert(K k) {
		root = insert(k, root);
	}

	private class AVLNode {
		public int element;	// int instead of generic since insert and remove specify ints	
		public int height;
//		public AVLNode parent;
		public AVLNode left;
		public AVLNode right;
		
		public AVLNode(int element){ 
			this.element = element;
			this.height = 0;
			left = null;
			right = null;
		}	
	}

}
