package com.hodor.ds.sort;

import com.hodor.ds.list.List;

public interface Sortable<T> {

	public void sort(T[] elements);

	public void sort(List<T> list);

}
