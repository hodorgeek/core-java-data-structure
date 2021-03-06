package com.hodor.ds.sort;

import org.junit.Assert;
import org.junit.Test;

import com.hodor.ds.sort.impl.BubbleSort;

public class BubbleSortTest {

	private static int N = 8;

	final Sortable<Integer> sortableInt = new BubbleSort<>();

	private int inputArr[] = { 5, 2, 8, 1, 6, 3, 7, 4 };

	private int[] expectedArr = { 1, 2, 3, 4, 5, 6, 7, 8 };

	@Test
	public void testBubbleSorting() {
		sortableInt.sort(inputArr, N);
		for (int i = 0; i < N; i++) {
			System.out.print(inputArr[i] + " ");
		}
		Assert.assertArrayEquals(expectedArr, inputArr);
	}
}
