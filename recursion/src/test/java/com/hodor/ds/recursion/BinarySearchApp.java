package com.hodor.ds.recursion;

import com.hodor.ds.recursion.BinarySearch;

public class BinarySearchApp {

	public static void main(String[] args) {
		int maxSize = 100;
		BinarySearch binarySearch;
		binarySearch = new BinarySearch(maxSize);

		binarySearch.insert(42);
		binarySearch.insert(25);
		binarySearch.insert(20);
		binarySearch.insert(30);
		binarySearch.insert(77);
		binarySearch.insert(70);
		binarySearch.insert(55);
		binarySearch.insert(10);
		binarySearch.insert(80);

		binarySearch.display();

		int searchKey = 24;
		int found = binarySearch.find(searchKey);
		if (found == -1) {
			System.out.println("can't find " + searchKey);
		} else {
			System.out.println(searchKey + " Found at " + found + " position");
		}
	}
}
