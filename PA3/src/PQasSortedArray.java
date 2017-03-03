
public class PQasSortedArray<C extends Comparable<? super C>> implements PQ<C> {
	private C[] arr;
	private int currentSize;

	public PQasSortedArray(int size) {
		arr = (C[]) new Comparable[size];
		currentSize = 0;
	}

	public boolean isFull() {
		return currentSize == arr.length;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override//our book has this code
	public void insert(C data) {
		if (currentSize == arr.length - 1) {
			enlargeArray(arr.length * 2 + 1);
		}
		// Percolate up
		int hole = ++currentSize;
		for (arr[0] = data; data.compareTo(arr[hole / 2]) < 0; hole /= 2)
			arr[hole] = arr[hole / 2];
		arr[hole] = data;
		// currentSize++;// one more item in array
		// int loc = currentSize;// starts it at 1, current place for the item
		// to
		// // be inserted
		// for (; data.compareTo(arr[loc / 2]) < 0; loc = loc / 2) {
		// arr[loc] = arr[loc / 2];// where to go
		// }
		// arr[loc] = data;// insert
	}

	private void enlargeArray(int newSize) {
		C[] old = arr;
		arr = (C[]) new Comparable[newSize];
		for (int i = 0; i < old.length; i++)
			arr[i] = old[i];
	}

	@Override
	public C min() {
		return arr[1];
	}

	@Override
	public C deleteMin() {
		C minItem = min();
		arr[1] = arr[currentSize--];
		deleteMinHelper(1);
		return minItem;
	}

	private void deleteMinHelper(int hole) {
		int child;
		C tmp = arr[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize && arr[child + 1].compareTo(arr[child]) < 0)
				child++;
			if (arr[child].compareTo(tmp) < 0)
				arr[hole] = arr[child];
			else
				break;
		}
		arr[hole] = tmp;
	}
}
