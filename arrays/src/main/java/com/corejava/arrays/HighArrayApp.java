package com.corejava.arrays;

public class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray highArray; // reference
		highArray = new HighArray(maxSize); // create an high array object

		long searchKey;

		// -----------------------------------------------------------------------------

		highArray.insert(77); // insert 10 items
		highArray.insert(99);
		highArray.insert(20);
		highArray.insert(34);
		highArray.insert(53);
		highArray.insert(87);
		highArray.insert(80);
		highArray.insert(73);
		highArray.insert(38);
		highArray.insert(50);
		
		highArray.display();
		
		// -----------------------------------------------------------------------------
		searchKey = 35;
		int searchKeyIndex = highArray.find(searchKey);
		if(searchKeyIndex != HighArray.DEFAULT_INDEX_VALUE) {
			System.out.println("Found " + searchKey);
		} else {
			System.out.println("can't find " + searchKey);
		}

		// -----------------------------------------------------------------------------
		highArray.delete(53);
		highArray.delete(20);
		highArray.delete(38);
		
		highArray.display();
	}
}
