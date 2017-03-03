
public class PQasSortedArray<C extends Comparable<? super C>> implements PQ<C> {
	private C[] arr;
	private int currentSize;

	public PQasSortedArray(int size) {
		arr = (C[]) new Comparable[size];
		currentSize = 0;
	}

	@Override
	public boolean isFull() {
		return currentSize == arr.length;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public void insert(C data) {
		//next, try to implement binary sort while inserting?
		//are recursions allowed?
		for (int i = 0; i < currentSize; i++) {
			if (data.compareTo(arr[i]) >= 0) {
				int loc = i;
				
				for (int j = currentSize; j > loc; j--) {
					arr[j] = arr[j - 1];
				}
				currentSize++;
				arr[loc] = data;
				return;
			}
		}
		arr[currentSize] = data;
		currentSize++;
	}

	@Override
	public C min() {
		return arr[currentSize - 1];
	}

	@Override
	public C deleteMin() {
		currentSize--;
		return arr[currentSize];
	}

}
