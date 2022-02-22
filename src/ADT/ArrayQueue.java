package ADT;

import Domain.ArrayQueue.EmptyQueueException;
import Domain.ArrayQueue.FullQueueException;

public class ArrayQueue {
	
	private int n;
	private Object array[];
	private int f;
	private int r;

	
	public ArrayQueue(int capacity) {		
		this.n = 0;
		array = new Object[capacity];
		this.r = capacity-1;
		this.f = r;
	}

	public boolean isEmpty() {
		return (f==r);
	}
	
	public int size() {
		return (this.array.length-f+r)%this.array.length;
	}
	
	public void enqueue(Object o) {
		if(size()==this.array.length-1) {
			throw new FullQueueException("Array Queue is Full");
		}
		else {
			array[r]=o;
			r = (r+1)%this.array.length;
		}
	}
	
	public Object dequeue() throws EmptyQueueException{
		
		Object o;
		
		if(isEmpty()) {
			throw new EmptyQueueException("Array Queue is Empty");
		}
		else {
			o = array[f];
			f = (f+1)%this.array.length;
		}
		return o;
	}
	
	public Object front() throws EmptyQueueException{
		Object o;
		
		if(isEmpty()) {
			throw new EmptyQueueException("Array Queue is Empty");
		}
		else {
			o = array[f];
		}
		return o;
	}
	
}
