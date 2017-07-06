package com.corejava.arrays;

/**
 * This is with the procedure oriented way.
 * 
 * Not defined the responsibility clearly. the array is traditional-->global and
 * not hided from the user of the app
 * 
 * @author hodorgeek
 *
 */
public class ArrayApp {

	public static void main(String[] args) {
		long arr[]; // reference to an array
		arr = new long[100];// make array/its an actual object
		int nElems = 0; // number of items

		int j; // loop counter
		long searchKey; // key of item search for

		// -----------------------------------------------------------------------------

		arr[0] = 77; // insert 10 items
		arr[1] = 99;
		arr[2] = 20;
		arr[3] = 34;
		arr[4] = 53;
		arr[5] = 87;
		arr[6] = 80;
		arr[7] = 73;
		arr[8] = 38;
		arr[9] = 50;
		
		nElems = 10; // now 10 items array

		// -----------------------------------------------------------------------------

		for (j = 0; j < nElems; j++) // display items
			System.out.print(arr[j] + " ");
		System.out.println("");

		// -----------------------------------------------------------------------------

		searchKey = 73;
		for (j = 0; j < nElems; j++)
			if (arr[j] == searchKey)
				break;
		if (j == nElems)
			System.out.println("can't find " + searchKey);
		else
			System.out.println("Found " + searchKey);

		// -----------------------------------------------------------------------------

		searchKey = 53; // delete item with key 55
		for (j = 0; j < nElems; j++) // look for it
			if (arr[j] == searchKey)
				break;

		// delete element from an array
		for (int k = j; k < nElems - 1; k++) // move higer ones down
			arr[k] = arr[k + 1];
		nElems--; // decrement size

		// -----------------------------------------------------------------------------

		for (j = 0; j < nElems; j++) // display items
			System.out.print(arr[j] + " ");
		System.out.println("");

		// -----------------------------------------------------------------------------
	}// end main

}// end class ArrayApp
