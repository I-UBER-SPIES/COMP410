import java.util.PriorityQueue;
import java.util.Random;

public class Tester {
	public static int n = 666;

	public static void main(String[] args) {
		PQasSortedArray<Double> pqHeap = new PQasSortedArray<>(n);
		long startTime, endTime;
		PQasSortedArray<Double> pq1 = new PQasSortedArray<>(n);
		PriorityQueue<Double> pq2 = new PriorityQueue<>(n);

		Random r = new Random();
		double[] arr1 = new double[n];
		double[] arr2 = new double[n];
		double[] arrHeap = new double[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = r.nextDouble();
			arr2[i] = arr1[i];
			arrHeap[i] = arr1[i];
		}

		startTime = System.nanoTime();
		for (int i = 0; i < arr1.length; i++)
			pq1.insert(arr1[i]);
		for (int i = arr1.length - 1; i >= 0; i--)
			arr1[i] = pq1.deleteMin();
		endTime = System.nanoTime();
		System.out.println("Took " + ((endTime - startTime) / 1000000) + " time units");

		startTime = System.nanoTime();
		for (int i = 0; i < arr1.length; i++)
			pq2.offer(arr1[i]); // "offer()" is insert()
		for (int i = arr1.length - 1; i >= 0; i--)
			arr1[i] = pq2.poll(); // "poll()" is deleteMin()
		endTime = System.nanoTime();
		System.out.println("Took " + ((endTime - startTime) / 1000000) + " time units");

		startTime = System.nanoTime();
		heapSort(arrHeap);
		endTime = System.nanoTime();
		System.out.println("Took " + ((endTime - startTime) / 1000000) + " time units");
	}

	public static void heapSort(double[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) /* buildHeap */
			percDown(arr, i, arr.length);
		for (int i = arr.length - 1; i > 0; i--) {
			swapReferences(arr, 0, i); /* deleteMax */
			percDown(arr, 0, i);
		}
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	private static <C extends Comparable<? super C>> void percDown(C[] a, int i, int n) {
		int child;
		C tmp;
		for (tmp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
				child++;
			if (tmp.compareTo(a[child]) < 0)
				a[i] = a[child];
			else
				break;
		}
		a[i] = tmp;
	}

	private static <C> void swapReferences(C[] a, int index1, int index2) {
		C tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

}
