package com.hodor.ds.queue;

public class Queue<E> {

	private int nItems;
	private int maxSize;
	private int front; // removal happens from the front
	private int rear; // insertion happens to the rear

	private Object[] queueArr;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queueArr = new Object[this.maxSize];
		nItems = 0;
		front = 0;
		rear = -1;
	}

	public void insert(E element) {
		if (rear == maxSize - 1) { // deal with wrap around
			rear = -1;
		}
		queueArr[++rear] = element; // increment and insert
		nItems++; // one more item
	}

	@SuppressWarnings("unchecked")
	public E remove() {
		E item = (E) queueArr[front++]; // get value and increment front
		if (front == maxSize) { // deal with wrap around
			front = 0;
		}
		nItems--; // one less item
		return item;
	}

	@SuppressWarnings("unchecked")
	public E peekFront() {
		return (E) queueArr[front];
	}

	public int size() {
		return nItems;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public boolean isEmpty() {
		return nItems == 0;
	}
}
