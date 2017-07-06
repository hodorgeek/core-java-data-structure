package com.corejava.arrays;

public class Partition {
	private long theArray[];

	private int nElems;

	public Partition(int maxSize) {
		this.theArray = new long[maxSize];
		this.nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;

		while (true) {
			// find the bigger one than the pivot
			while (leftPtr < rightPtr && theArray[++leftPtr] < pivot)
				;
			// find the smaller one than the pivot
			while (rightPtr > leftPtr && theArray[--rightPtr] > pivot)
				;

			if (leftPtr >= rightPtr) { // if leftPtr and rightPtr cross
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		return leftPtr;
	}

	private void swap(int left, int right) {
		long temp = theArray[left];
		theArray[left] = theArray[right];
		theArray[right] = temp;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
}
