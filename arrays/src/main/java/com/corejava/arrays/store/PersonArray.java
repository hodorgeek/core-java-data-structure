package com.corejava.arrays.store;

public class PersonArray {

	private Person a[];

	private int nElems;

	public PersonArray(int max) {
		a = new Person[max];
		this.nElems = 0;
	}

	public void insert(String lastName, String firstName, int age) {
		a[nElems] = new Person(lastName, firstName, age);
		nElems++;
	}

	public Person find(String lastName) {
		Person p = null;
		for (int i = 0; i < nElems; i++) {
			if (a[i].getLastName().equalsIgnoreCase(lastName)) {
				p = a[i];
				break;
			}
		}
		return p;
	}

	public boolean delete(String lastName) {
		boolean isDeleted = false;
		int i;
		for (i = 0; i < nElems; i++) {
			if (a[i].getLastName().equalsIgnoreCase(lastName)) {
				break;
			}
		}
		// if the i is equal to number of items in the array then key can't find
		if (i != nElems) {
			for (int k = i; k < nElems; k++) {
				a[k] = a[k + 1];
			}
			nElems--;
			isDeleted = true;
		}

		return isDeleted;
	}

	// -----------------------------------------------------------------------------
	/**
	 * Applies the insertion sort on the array of person object based on the
	 * last name.
	 */
	public void insertionSort() {
		int out = 0;
		int in = 0;
	}

	public void displayPerson() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(a[i]);
		}
	}
}
