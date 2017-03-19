package com.hodor.ds.sort;

public abstract class AbstractSortingData {

	private static final String HODOR = "hodor";

	public Object[] createStringArray(final int n) {
		final Object[] stringArr = new String[n];
		for (int i = 0; i < n; i++) {
			stringArr[i] = new StringBuilder(HODOR).append(String.valueOf(Math.random() * 1000));
		}
		return stringArr;
	}

	public Object[] createIntArray(final int n) {
		final Object[] intArr = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArr[i] = (int) (Math.random() * 1000);
		}
		return intArr;
	}

	/*public List<Integer> createIntList(final Integer[] objArr) {
		final List<Integer> list = new SinglyLinkedList<>();
		list.addAll(objArr);
		return list;
	}

	public List<String> createStringList(final String[] objArr) {
		final List<String> list = new SinglyLinkedList<>();
		list.addAll(objArr);
		return list;
	}*/
}