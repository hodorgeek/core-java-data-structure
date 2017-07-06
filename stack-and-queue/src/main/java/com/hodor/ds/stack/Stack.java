package com.hodor.ds.stack;

import com.hodor.ds.stack.exception.StackOverlowException;
import com.hodor.ds.stack.exception.StackUnderflowException;

public class Stack<T> {

	private int top;
	private int maxSize;
	private Object elements[];

	public static final int INIT_TOP = -1;

	public Stack(int maxSize) {
		this.top = INIT_TOP;
		this.maxSize = maxSize;
		this.elements = new Object[this.maxSize];
	}

	/**
	 * Increment the top by one and pushed the element T on the new top of the
	 * stack.
	 * 
	 * @param element
	 */
	public void push(T element) {
		if (!isOverflow()) {
			elements[++top] = element;
		} else {
			throw new StackOverlowException("can't pushed item, stack overflow");
		}
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (!isUnderflow()) {
			return (T) elements[top--];
		} else {
			throw new StackUnderflowException("can't popped item, stack underflow");
		}
	}

	/**
	 * Always return the element on the top of the stack but does not not popped
	 * it from the stack
	 * 
	 * @return the top most element
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) elements[top];
	}

	@SuppressWarnings("unchecked")
	public T peekN(int n) { // peek item at index n
		return (T) elements[n];
	}

	public int size() {
		return top + 1;
	}

	public boolean isOverflow() {
		return top == maxSize - 1;
	}

	public boolean isUnderflow() {
		return top == INIT_TOP;
	}
}
