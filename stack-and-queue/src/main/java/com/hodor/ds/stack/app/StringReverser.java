package com.hodor.ds.stack.app;

import com.hodor.ds.stack.Stack;

public class StringReverser {

	public String revereString(final String input) {
		Stack<Character> inputCharStack = new Stack<>(input.length());

		// push all the character on the stack
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			inputCharStack.push(ch);
		}

		// until stack is empty pop one by one character from top of the string
		StringBuilder stringBuilder = new StringBuilder();
		while (!inputCharStack.isUnderflow()) {
			Character ch = inputCharStack.pop();
			stringBuilder.append(ch.toString());
		}
		return stringBuilder.toString();
	}
}
