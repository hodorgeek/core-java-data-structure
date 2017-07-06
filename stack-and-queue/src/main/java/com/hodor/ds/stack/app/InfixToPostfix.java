package com.hodor.ds.stack.app;

import com.hodor.ds.stack.Stack;

public class InfixToPostfix {

	public String convert(final String infixString) {
		final Stack<Character> theStack = new Stack<>(infixString.length());
		StringBuilder output = new StringBuilder();
		// reading/scanning the infix string from left to right
		for (int j = 0; j < infixString.length(); j++) {
			Character ch = infixString.charAt(j);
			displayStack("For  " + ch + " ", theStack);
			switch (ch) {
			case '+':
			case '-': // its + or -
				processOperator(ch, 1, theStack, output); // go pop operators,
															// precedence
				// 1
				break;
			case '*':
			case '/': // its * or /
				processOperator(ch, 2, theStack, output); // go pop operator,
															// precedence 2
				break;
			case '(': // if its left parenthesis push it top of the stack
				theStack.push(ch);
				break;
			case ')': // if its right parenthesis
				processParenthesis(ch, theStack, output); // go pop operators
				break;
			default: // must be an operand write it to output
				output.append(ch.toString());
				break;
			}
		}

		// pop remaining operators
		while (!theStack.isUnderflow()) {
			displayStack("while ", theStack);
			output.append(theStack.pop().toString());
		}
		displayStack("End  ", theStack);
		return output.toString();
	}

	private void processOperator(final Character opThis, final int precedence1, final Stack<Character> theStack,
			final StringBuilder output) {
		while (!theStack.isUnderflow()) {
			Character opTop = theStack.pop();
			if (opTop == '(') { // if its a '('
				theStack.push(opTop); // restore '('
				break;
			} else { // its an operator
				int precedence2; // precedence of new top
				if (opTop == '+' || opTop == '-') {// find the new precedence of
													// new operator
					precedence2 = 1;
				} else {
					precedence2 = 2;
				}
				// check prec of new op with the old one
				if (precedence2 < precedence1) { // prec of new op is less than
													// old op
					theStack.push(opTop); // save newly popped operator
					break;
				} else {
					output.append(opTop);
				}
			}
		}
		// push new operator
		theStack.push(opThis);
	}

	private void processParenthesis(final Character ch, final Stack<Character> theStack, final StringBuilder output) {
		while (!theStack.isUnderflow()) {
			Character chx = theStack.pop();
			if (chx != '(') {
				output.append(chx.toString());
			} else {
				break;
			}
		}
	}

	private void displayStack(final String s, final Stack<Character> theStack) {
		System.out.print(s);
		System.out.print(" Stack (bottom-->top) : ");
		for (int j = 0; j < theStack.size(); j++) {
			System.out.print(theStack.peekN(j));
			System.out.print(' ');
		}
		System.out.println("");
	}
}
