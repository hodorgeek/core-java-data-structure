package com.corejava.arrays;

/**
 * Demonstrates the array class with the high array interface
 * 
 * @author hodorgeek
 *
 */
public class HighArray {
	
	private long a[];			//ref to array a
	private int nElem;		//number of data items
	
	public static final int DEFAULT_INDEX_VALUE = -1;
	
	// ---------------------------------------------------------
	
	public HighArray(int max) {	//constructor
		a = new long[max];		//create the array
		this.nElem = 0;			//no items yet
	}	
	
	// ---------------------------------------------------------
	public int find(long searchKey) {
		int searchIndex = DEFAULT_INDEX_VALUE;
		for(int i=0;i<nElem;i++) {
			if(a[i] == searchKey) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
	
	// ---------------------------------------------------------
	public boolean delete(long deleteKey) {
		int deleteIndex = find(deleteKey);
		boolean isDeleted = false;
		if(deleteIndex != DEFAULT_INDEX_VALUE) {
			for(int k=deleteIndex;k<nElem;k++) {
				a[k] = a[k+1];	//move higher ones down
			}
			isDeleted = true;
			nElem--;
		}
		return isDeleted;
	}
	
	// ---------------------------------------------------------
	public void insert(long dataItem) {
		a[nElem] = dataItem;
		nElem++;
	}
	
	// ---------------------------------------------------------
	public void display() {
		for(int i=0;i<nElem;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
}
