package com.hodor.ds.queue;

/**
 * Demonstrates the priority queue implementation using an array
 * 
 * array in sorted order max at 0 and min at size-1
 * 
 * @author hodorgeek
 *
 */
public class PriorityQ {

	private int maxSize;
	private int nItems;

	private long[] queueArr;

	public PriorityQ(int maxSize) {
		this.maxSize = maxSize;
		queueArr = new long[this.maxSize];
		nItems = 0;
	}

	public long remove() { // remove minimum item
		return queueArr[--nItems];
	}

	public void insert(long element) {
		int j = 0;
		if (nItems == 0) { // if no items insert at 0
			queueArr[nItems++] = element;
		} else {
			// start at end
			for (j = nItems - 1; j >= 0; j--) {
				if (element > queueArr[j]) { // if new item is larger
					queueArr[j + 1] = queueArr[j]; // shift upward by
													// one position
				} else {
					// if smaller done shifting
					break;
				}
			}

			queueArr[j + 1] = element;
			nItems++;
		}
	}

	public long peekMin() {
		return queueArr[nItems - 1];
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
