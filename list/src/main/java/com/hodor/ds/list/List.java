package com.hodor.ds.list;

import com.hodor.ds.list.exceptions.ElementNotFoundException;

public interface List<T> {

	public void add(T element);

	public void addFirst(T element);

	public void addLast(T element);

	public void add(int position, T element);
	
	public  void  addInSortPosition(Comparable<T> element);

	public void addAll(T[] elements);

	public void addAll(int index, T[] elements);

	public void addAll(List<T> list);

	public void addAll(int index, List<T> list);

	public boolean remove(T element);

	public T removeFirst();

	public T removeLast();

	public T remove(int index);

	public void reverse();

	public List<T> reverseList();

	public T get(int index);

	public T getFirst();

	public T getLast();

	public T set(int index, T newElement) throws ElementNotFoundException;

	public boolean isEmpty();

	public boolean contains(T element);

	public int indexOf(T element);

	public int lastIndexOf(T element);

	public void printList();

	public void clear();

	public int size();

	public Object[] toArray();

	public boolean equals(List<T> list);
}
