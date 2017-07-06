package com.hodor.ds.list;

import com.hodor.ds.list.sll.SinglyLinkedList;

/**
 * Implementation of stack using linked list
 * 
 * @author hodorgeek
 *
 * @param <T>
 */

public class Stack<T> {

	private List<T> list;

	public Stack() {
		list = new SinglyLinkedList<>();
	}

	public void push(T element) {
		list.addLast(element);
	}

	public T pop() {
		return list.removeLast();
	}

	public int size() {
		return list.size();
	}

	public boolean isUnderflow() {
		return list.isEmpty();
	}
}
