package com.corejava.arrays;

/**
 * 
 * Demonstrates merging two arrays into third one
 * 
 * @author hodorgeek
 *
 */
public class MergeApp {
	public static void main(String[] args) {

		int arrayA[] = { 23, 47, 81, 95 };
		int arrayB[] = { 7, 14, 39, 55, 62, 74 };

		int arrayC[] = new int[10];

		merge(arrayA, 4, arrayB, 6, arrayC);

		display(arrayC, 10);
	}

	/**
	 * Merge A and B into C
	 * 
	 * @param arrayA
	 * @param sizeA
	 * @param arrayB
	 * @param sizeB
	 * @param arrayC
	 */
	private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		int i = 0, j = 0, k = 0;

		// while there are elements in A and B
		while (i < sizeA && j < sizeB) { // neither array empty
			// compare and copying into third one
			if (arrayA[i] < arrayB[j]) {
				arrayC[k++] = arrayA[i++];
			} else {
				arrayC[k++] = arrayB[j++];
			}
		}

		// if there are no elements in B, copying the remaining of A
		while (i < sizeA) { // arrayB is empty, but arrayA isn't
			arrayC[k++] = arrayA[i++];
		}

		// if there are no elements in A, copying the remaining of B
		while (j < sizeB) { // arrayA is empty, but arrayB isn't
			arrayC[k++] = arrayB[j++];
		}
	}

	private static void display(int[] arrayC, int sizeC) {
		for (int i = 0; i < sizeC; i++) {
			System.out.print(arrayC[i] + " ");
		}
		System.out.println();
	}
}
