package com.hodor.ds.queue;

/**
 * An array based implementation for a queue without keeping track of the items
 * count variable. The insert and delete operation implementation are the almost
 * similar that of {@code Queue} class. The major change is in the queue full
 * and empty implementation
 * 
 * @author hodorgeek
 *
 * @param <E>
 *            the type of the Element for the Queue
 */
public class QueueWithoutCount<E> {

	private int maxSize;
	private int front;
	private int rear;

	private Object[] queueArr;

	public QueueWithoutCount(int size) {
		this.maxSize = size + 1; // array is 1 cell larger than requested
		queueArr = new Object[this.maxSize];
		front = 0;
		rear = -1;
	}

	public void insert(E element) { // put an item rear of the queue
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queueArr[++rear] = element;
	}

	@SuppressWarnings("unchecked")
	public E remove() { // get/delete item from the front of the queue
		E item = (E) queueArr[front++];
		if (front == maxSize) {
			front = 0;
		}
		return item;
	}

	@SuppressWarnings("unchecked")
	public E peekFront() {
		return (E) queueArr[front];
	}

	public boolean isFull() { // true if queue is full
		return (rear + 2 == front || (front + maxSize - 2 == rear));
	}

	public boolean isEmpty() { // true if queue is empty
		return (rear + 1 == front || (front + maxSize - 1 == rear));
	}

	public int size() { // (assumes queue is not empty
		if (rear >= front) { // contiguous sequence
			return rear - front + 1;
		} else { // broken sequence
			return (maxSize - front) + (rear + 1);
		}
	}
}
