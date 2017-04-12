
public class DDasAVL<K extends Comparable<? super K>, D> implements DD<K, D> {

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

    @Override
    public void insert(K k, D d) {
        root = insert(root, k, d);
    }

    @Override
    public D find(K k) {
        return find(root, k);
    }

    @Override
    public void remove(K k) {
        root = remove(root, k);
    }

    public int height() { // Not relevant to DD's -- used for comparing performance with AVL trees
        return height(root);
    }

    private AVLtree<K, D> insert(AVLtree<K, D> t, K k, D d) { // Complete this
        if (t == null) return new AVLtree<K, D>(k, d, null, null);
        int compareResult = k.compareTo(t.key);
        if (compareResult < 0) {
            t.left = insert(t.left, k, d);
        } else if (compareResult > 0) {
            t.right = insert(t.right, k, d);
        } else {
            t.deleted = false;
            t.data = d;
        }

        return balance(t);
    }

    private D find(AVLtree<K, D> t, K k) { // Complete this
        if (t == null) return null;
        int compareResult = k.compareTo(t.key);
        if (compareResult < 0) return (D) find(t.left, k);
        else if (compareResult > 0) return (D) find(t.right, k);
        else if (!t.deleted) return t.data;
        else return null;
    }

    private AVLtree<K, D> findMin(AVLtree<K, D> t) { // Complete this
        if (t.left == null || !t.deleted) return t;
        return findMin(t.left);
    }

    private AVLtree<K, D> remove(AVLtree<K, D> t, K k) {  // Implement using LAZY DELETE!!
        if (t == null) return null;
        int compareResult = k.compareTo(t.key);
        if (compareResult < 0) remove(t.left, k);
        else if (compareResult > 0) remove(t.right, k);
        else t.deleted = true;

        return t;
    }

    private int height(AVLtree<K, D> t) {
        return (t == null) ? -1 : t.height;
    }

    private AVLtree<K, D> balance(AVLtree<K, D> t) {
        if (t == null) return t;
        if (height(t.left) - height(t.right) > 1)
            if (height(t.left.left) >= height(t.left.right))
                t = rotateLL(t);  // do an LL rotation
            else
                t = rotateLR(t);  // do an LR rotation
        else if (height(t.right) - height(t.left) > 1)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateRR(t);  // do an RR rotation
            else
                t = rotateRL(t);  // do an RL rotation

        t.height = 1 + Math.max(height(t.left), height(t.right));
        return t;
    }

    // Single rotation
    private AVLtree<K, D> rotateLL(AVLtree<K, D> k2) { // Complete this
        AVLtree<K, D> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }


    // Double rotation
    private AVLtree<K, D> rotateLR(AVLtree<K, D> k2) { // Complete this
        k2.left = rotateRR(k2.left);
        return rotateLL(k2);
    }


    // Single rotation
    private AVLtree<K, D> rotateRR(AVLtree<K, D> k2) { // Complete this
        AVLtree<K, D> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }


    // Double rotation
    private AVLtree<K, D> rotateRL(AVLtree<K, D> k2) { // Complete this
        k2.right = rotateLL(k2.right);
        return rotateRR(k2);
    }

    public AVLtree<K, D> getRootTree() {
        return root;
    }

}