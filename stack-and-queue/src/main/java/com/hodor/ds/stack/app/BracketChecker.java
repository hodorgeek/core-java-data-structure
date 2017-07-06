package com.hodor.ds.stack.app;

import com.hodor.ds.stack.Stack;

/**
 * stack is used to check the matching delimeter
 * @author hodorgeek
 *
 */
public class BracketChecker {

	public void check(final String inputDelimeter) {
		final Stack<Character> theStack = new Stack<>(inputDelimeter.length());
		for (int i = 0; i < inputDelimeter.length(); i++) {
			Character ch = inputDelimeter.charAt(i);
			switch (ch) {
			case '(':
			case '[':
			case '{':
				theStack.push(ch);
				break;
			case ')':
			case ']':
			case '}':
				if (!theStack.isUnderflow()) {
					Character chx = theStack.pop();
					if ((ch == ')' && chx != '(') || (ch == ']' && chx != '[') || (ch == '}' && chx != '{')) {
						System.out.println("Error :" + ch + " at " + i);
					}
				} else {
					System.out.println("Error :" + ch + " at " + i);
				}
			default: // no action for other characters
				break;
			}
		}
		// at this point all the characters have been processed
		if (!theStack.isUnderflow()) {
			System.out.println("Error:missing right delimeter");
		}
	}
}
