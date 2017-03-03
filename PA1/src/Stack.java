
public class Stack<T> {
	private int size;
	private Node<T> top;
	private int capacity;

	public class Node<U> {
		T data;
		Node<T> next;

		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}

	}

	public Stack(int capacity) {
		size = 0;
		top = null;
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public T peek() {
		return top.data;
	}

	public T pop() {
			T temp = top.data;
			top = top.next;
			this.size--;
			return temp;
		
	}

	public void push(T element) {
		Node<T> temp = new Node<T>(element, top);
		top = temp;
		size++;
	}
}
