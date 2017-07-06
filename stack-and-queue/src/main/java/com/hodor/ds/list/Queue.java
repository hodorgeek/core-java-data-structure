package com.hodor.ds.list;

import com.hodor.ds.list.sll.SinglyLinkedList;

/**
 * Implementation of Queue using linked list
 * 
 * @author hodorgeek
 *
 */
public class Queue<E> {

	private List<E> list;

	public Queue() {
		list = new SinglyLinkedList<>();
	}

	public void insert(E element) {
		list.addLast(element);
	}
	
	public E remove() {
		return list.removeFirst();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
