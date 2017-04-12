
public class AVLtree<K extends Comparable<? super K>, D> {

    public AVLtree left, right;
    public K key;
    public D data;
    public boolean deleted;
    public int height;

    public AVLtree(K k, D d, AVLtree<K, D> l, AVLtree<K, D> r) {
        key = k;
        data = d;
        left = l;
        deleted = false;
        height = 0;
    }

}