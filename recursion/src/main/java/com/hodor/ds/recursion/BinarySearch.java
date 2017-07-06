package com.hodor.ds.recursion;

public class BinarySearch {
	private long a[];
	private int nElem;

	public BinarySearch(int maxSize) {
		this.a = new long[maxSize];
		this.nElem = 0;
	}

	public int size() {
		return nElem;
	}

	public void insert(long value) {
		int j = 0;
		for (j = 0; j < nElem; j++) {
			if (a[j] > value) {
				break;
			}
		}

		for (int k = nElem; k > j; k--) {
			a[k] = a[k - 1];
		}

		a[j] = value;
		nElem++;
	}

	public int find(int searchKey) {
		return recFind(searchKey, 0, nElem - 1);
	}

	public int recFind(long searchKey, int lowerBound, int upperBound) {
		int middle;
		middle = (lowerBound + upperBound) / 2;
		if (searchKey == a[middle]) {
			return middle;
		} else if (lowerBound > upperBound) {
			return -1; // can't find
		} else {
			if (searchKey > a[middle])
				return recFind(searchKey, middle + 1, upperBound);
			else
				return recFind(searchKey, lowerBound, middle - 1);
		}
	}

	public void display() {
		for (int i = 0; i < nElem; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
}
