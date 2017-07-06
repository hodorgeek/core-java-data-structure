package com.corejava.arrays;

/**
 * Dividing classes The data storage structure itself is one of the class and
 * the part of the program that uses it is another
 * 
 * @author hodorgeek
 *
 */
public class LowArrayApp {
	public static void main(String[] args) {
		LowArray lowArray; // reference
		lowArray = new LowArray(100); // create an low array object
		int nElems = 0;
		int j = 0;

		long searchKey;

		// -----------------------------------------------------------------------------

		lowArray.setElem(0, 77); // insert 10 items
		lowArray.setElem(1, 99);
		lowArray.setElem(2, 20);
		lowArray.setElem(3, 34);
		lowArray.setElem(4, 53);
		lowArray.setElem(5, 87);
		lowArray.setElem(6, 80);
		lowArray.setElem(7, 73);
		lowArray.setElem(8, 38);
		lowArray.setElem(9, 50);

		nElems = 10; // now 10 items array

		// -----------------------------------------------------------------------------

		for (j = 0; j < nElems; j++) // display items
			System.out.print(lowArray.getElem(j) + " ");
		System.out.println("");

		// -----------------------------------------------------------------------------

		searchKey = 73; // search item with key 73
		for (j = 0; j < nElems; j++)
			if (lowArray.getElem(j) == searchKey)
				break;
		if (j == nElems)
			System.out.println("can't find " + searchKey);
		else
			System.out.println("Found " + searchKey);

		// -----------------------------------------------------------------------------

		searchKey = 50; // delete item with key 50
		for (j = 0; j < nElems; j++) // look for it
			if (lowArray.getElem(j) == searchKey)
				break;

		// delete element from an array
		for (int k = j; k < nElems - 1; k++) // move higer ones down
			lowArray.setElem(k, lowArray.getElem(k + 1));
		nElems--; // decrement size

		// -----------------------------------------------------------------------------

		for (j = 0; j < nElems; j++) // display items
			System.out.print(lowArray.getElem(j) + " ");
		System.out.println("");

		// -----------------------------------------------------------------------------
	}
}
