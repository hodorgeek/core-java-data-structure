package com.hodor.ds.sort.impl;

import com.hodor.ds.sort.Sortable;

public class BubbleSort<T> implements Sortable<T> {

	@Override
	public void sort(int[] elements, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (elements[i] > elements[j]) {
					final int temp = elements[i];
					elements[i] = elements[j];
					elements[j] = temp;
				}
			}
		}
	}
}
