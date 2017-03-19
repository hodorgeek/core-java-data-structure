package com.hodor.ds.sort.impl;

import com.hodor.ds.sort.Sortable;

public class SelectionSort<T> implements Sortable<T> {

	@Override
	public void sort(int[] elements, int N) {
		for (int i = 0; i < N - 1; i++) {
			int iMin = i;
			for (int j = i + 1; j < N; j++) {
				if (elements[j] < elements[iMin]) {
					iMin = j;
				}
			}

			// swap the elements
			int temp = elements[i];
			elements[i] = elements[iMin];
			elements[iMin] = temp;
		}
	}

}
