
public class VipQueue<T>{
	private Stack<T> vstack;
	private Queue<T> vqueue;
	private int size, maxSize;
	
	public VipQueue(int capacity){
		size = 0;
		maxSize = capacity;
		vqueue = new Queue<T>(capacity);
		vstack = new Stack<T>(capacity);
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return maxSize == size;
	}
	
	public T peek(){
		if(vstack.isEmpty()){
			return vqueue.peek();
		}else{
			return vstack.peek();
		}
	}
	
	public T dequeue(){
		size--;
		if(vstack.isEmpty()){
			return vqueue.dequeue();
		} else {
			return vstack.pop();
		}
	}
	
	public void enqueue(T element){
		vqueue.enqueue(element);
		size++;
	}
	
	public void vipEnqueue(T element){
		vstack.push(element);
		size++;
	}
	public int count(){
		return size;
	}
}
