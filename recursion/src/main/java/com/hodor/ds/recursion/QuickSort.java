package com.hodor.ds.recursion;

public class QuickSort {
	private long theArray[];

	private int nElems;

	public QuickSort(int maxSize) {
		this.theArray = new long[maxSize];
		this.nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void sort(int left, int right) {
		recSort(left, right);
	}

	private void recSort(int left, int right) {
		if (right - left <= 0) { // if its single that means its already sorted
			return; // start returning
		} else {

			// take last index as pivot
			long pivot = theArray[right];

			// partitioned the array into left and right subarray
			int partition = partition(left, right, pivot);

			// sort the left sub array
			recSort(left, partition - 1);

			// sort the right sub array
			recSort(partition + 1, right);
		}
	}

	public int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {
			// find the bigger one than the pivot
			while (theArray[++leftPtr] < pivot)
				;
			// find the smaller one than the pivot
			while (rightPtr > 0 && theArray[--rightPtr] > pivot)
				;

			if (leftPtr >= rightPtr) { // if leftPtr and rightPtr cross
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right); // restore the pivot
		return leftPtr; // return pivot location
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
