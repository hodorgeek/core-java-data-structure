package com.hodor.ds.stack;

public class StackTest {

	public static void main(String[] args) {

		final Stack<Long> theStack = new Stack<>(10); // make a new stack of size 10

		// push the item to stack
		theStack.push(new Long(20));
		theStack.push(new Long(15));
		theStack.push(new Long(25));
		theStack.push(new Long(30));
		theStack.push(new Long(40));

		// until its empty delete item from the top
		while (!theStack.isUnderflow()) {
			final Long item = theStack.pop();
			System.out.print(item + " "); // display it
		}
		System.out.println("");
	}
}
