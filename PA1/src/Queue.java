
public class Queue<T>{
	public T queueArr[];
	public int front, back, maxSize, length;
	public Queue(int capacity){
		front = 0;
		back = -1;
		maxSize = capacity;
		length=0;
		queueArr = (T[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return maxSize == 0;
	}
	
	public boolean isFull(){
		return maxSize == length;
	}
	
	public T peek(){
		return queueArr[front];
	}
	
	public T dequeue(){
		T temp = queueArr[front];
		front = (front+1)%queueArr.length;
		length--;
		return temp;
	}
	
	public void enqueue(T element){
		back = (back+1)%queueArr.length;
		queueArr[back] = element;
		length++;
	}
}
