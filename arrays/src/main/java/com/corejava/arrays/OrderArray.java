package com.corejava.arrays;

public class OrderArray {

	private long[] a; // ref to array
	private int nELems; // keep the track for number of elements in the array

	public static final int DEFAULT_INDEX_VALUE = -1;

	// -----------------------------------------------------------------------------
	public OrderArray(int max) {
		a = new long[max];
		this.nELems = 0;
	}

	// -----------------------------------------------------------------------------
	public int find(long searchKey) {
		int lower = 0;
		int upper = nELems - 1;
		int mid = 0;
		while (true) {
			mid = (lower + upper) / 2;
			if (searchKey == a[mid]) {
				break; // break the loop when element is found
			} else if (lower > upper) {
				mid = DEFAULT_INDEX_VALUE; // can't finds
				break;
			} else { // divide the range
				if (searchKey > a[mid]) {
					lower = mid + 1; // its in upper half
				} else {
					upper = mid - 1; // its in lower half
				}
			}
		}
		return mid;
	}

	public int size() {
		return nELems;
	}

	// assuming there is no duplicates in the array
	public void insert(long value) {
		int i, k;
		for (i = 0; i < nELems; i++) {
			if (a[i] > value) {
				break; // find the appropriate position for inserting a value
			}
		}

		// shifting the elements from last to the i by one index
		for (k = nELems; k > i; k--) {
			a[k] = a[k - 1];
		}

		a[i] = value;
		nELems++;
	}

	public boolean delete(long deleteKey) {
		boolean isDeleted = false;
		final int index = find(deleteKey); // find the index of the deleteKey
		if (index != DEFAULT_INDEX_VALUE) { // if element is found
			// shift the elements down one index
			for (int i = index; i < nELems; i++) {
				a[i] = a[i + 1];
			}
			nELems--;
			isDeleted = true;
		}
		return isDeleted;
	}

	public void display() {
		for (int i = 0; i < nELems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
}
