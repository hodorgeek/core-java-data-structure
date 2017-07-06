package com.hodor.ds.recursion;

public class MergeSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		MergeSort mergeSort;
		mergeSort = new MergeSort(maxSize);

		mergeSort.insert(42);
		mergeSort.insert(25);
		mergeSort.insert(20);
		mergeSort.insert(30);
		mergeSort.insert(77);
		mergeSort.insert(70);
		mergeSort.insert(55);
		mergeSort.insert(10);
		mergeSort.insert(80);

		mergeSort.display();
		mergeSort.mergeSort();
		mergeSort.display();
	}
}
