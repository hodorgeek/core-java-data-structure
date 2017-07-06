package com.corejava.arrays;

/**
 * Dividing a program:ArrayApp into classes. Demonstrates the array classes with
 * low level interfaces
 * 
 * @author hodorgeek
 *
 */
public class LowArray {

	private long[] a; // ref to array a

	// ---------------------------------------------------------
	public LowArray(int size) { // constructor
		a = new long[size]; // create an array
	}
	// ---------------------------------------------------------

	public void setElem(int index, long value) {
		this.a[index] = value; // set the value
	}

	// ---------------------------------------------------------
	public long getElem(int index) {
		return this.a[index]; // get the valueF
	}
	// ---------------------------------------------------------
}// end of class LowArray
