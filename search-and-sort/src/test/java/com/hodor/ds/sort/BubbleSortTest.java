package com.hodor.ds.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hodor.ds.list.List;
import com.hodor.ds.list.sll.SinglyLinkedList;
import com.hodor.ds.sort.impl.BubbleSort;

public class BubbleSortTest extends AbstractSortingData {

	private static int N = 8;

	private Object[] intArr, expectedIntArr;

	private Object[] stringArr, expectedStringArr;

	private List<Integer> intList, expectedIntList;

	private List<String> stringList, expectedStringList;

	final Sortable<Integer> sortableInt = new BubbleSort<>();

	final Sortable<String> sortableString = new BubbleSort<>();

	@BeforeClass
	public void setUp() {
		intArr = createIntArray(N);
		stringArr = createStringArray(N);
		intList = createIntList((Integer[]) intArr);
		stringList = createStringList((String[]) stringArr);

		expectedIntArr = Arrays.copyOf(intArr, N);
		expectedStringArr = Arrays.copyOf(stringArr, N);
		Arrays.sort(expectedIntArr);
		Arrays.sort(expectedStringArr);

		expectedIntList = new SinglyLinkedList<>();
		expectedIntList.addAll((Integer[]) expectedIntArr);
		expectedStringList = new SinglyLinkedList<>();
		expectedStringList.addAll((String[]) expectedStringArr);

	}

	@Test
	public void testObjectArray() {
		sortableInt.sort((Integer[]) intArr);
		Assert.assertEquals(N, intArr.length);
		Assert.assertArrayEquals(expectedIntArr, intArr);

		sortableString.sort((String[]) stringArr);
		Assert.assertEquals(N, stringArr.length);
		Assert.assertArrayEquals(expectedStringArr, stringArr);
	}

	@Test
	public void testList() {
		sortableInt.sort(intList);
		Assert.assertEquals(N, intList.size());
		Assert.assertTrue(intList.equals(expectedIntList));
		Assert.assertArrayEquals(expectedIntArr, intList.toArray());

		sortableString.sort(stringList);
		Assert.assertEquals(N, stringList.size());
		Assert.assertTrue(stringList.equals(expectedStringList));
		Assert.assertArrayEquals(expectedStringArr, stringList.toArray());
	}
}
