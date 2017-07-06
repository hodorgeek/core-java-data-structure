package com.hodor.ds.recursion;

/**
 * 
 * Demonstrates the recursive merge sort
 * 
 * @author hodorgeek
 *
 */
public class MergeSort {

	private long[] theArray;
	private int nElems;

	public MergeSort(int maxSize) {
		this.theArray = new long[maxSize];
		this.nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void insert(long value) { // put element into an aray
		theArray[nElems++] = value;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}

	public void mergeSort() { // called by main, provide workspace
		long[] workspace = new long[nElems];
		recMergeSort(workspace, 0, nElems-1);
	}

	private void recMergeSort(long[] workspace, int lowerBound, int upperBound) {

		if (lowerBound == upperBound) { // if range is one, no sorting
			return; // start returning
		} else {

			// find midpoint
			int mid = (lowerBound + upperBound) / 2;

			// sort lower half
			recMergeSort(workspace, lowerBound, mid);

			// sort upper half
			recMergeSort(workspace, mid + 1, upperBound);

			// Merge them
			merge(workspace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(long[] workspace, int lowPtr, int highPtr, int upperBound) {

		int k = 0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound - lowerBound + 1 ;
		while (lowPtr <= mid && highPtr <= upperBound) {
			if (theArray[lowPtr] < theArray[highPtr]) {
				workspace[k++] = theArray[lowPtr++];
			} else {
				workspace[k++] = theArray[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			workspace[k++] = theArray[lowPtr++];
		}

		while (highPtr <= upperBound) {
			workspace[k++] = theArray[highPtr++];
		}

		for (k = 0; k < n; k++) {
			theArray[lowerBound + k] = workspace[k];
		}
	}
}
