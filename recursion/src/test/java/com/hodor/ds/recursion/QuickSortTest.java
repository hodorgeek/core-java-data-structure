package com.hodor.ds.recursion;

public class QuickSortTest {
	public static void main(String[] args) {
		int maxSize = 100;
		QuickSort quickSort = new QuickSort(maxSize);
		int nElems = 16;
		for (int i = 0; i < nElems; i++) {
			long n = (long) (Math.random() * 199);
			quickSort.insert(n);
		}
		quickSort.display();
		// return the partition position in the array:this is the index of the
		// first element in the right group
		//System.out.println("Partition position:" + quickSort.partition(0, nElems - 1, pivot));
		quickSort.sort(0, nElems-1);
		quickSort.display();
	}
}
