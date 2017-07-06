package com.hodor.ds.stack.app;

import com.hodor.ds.stack.Stack;

public class PostfixExpressionEvalutor {

	public Integer evaluate(String postfixExpression) {
		final Stack<Integer> theStack = new Stack<>(postfixExpression.length());
		Integer result = null;
		int num1, num2;
		for (int j = 0; j < postfixExpression.length(); j++) {
			Character ch = postfixExpression.charAt(j);
			displayStack(" " + ch.toString() + " ", theStack);
			if (ch >= '0' && ch <= '9') {
				theStack.push((int) (ch - '0'));
			} else {
				num2 = theStack.pop(); // pop operands
				num1 = theStack.pop();
				switch (ch) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					result = 0;
					break;
				}
				// push the result
				theStack.push(result);
			}
		}
		result = theStack.pop();
		return result;
	}

	private void displayStack(final String s, final Stack<Integer> theStack) {
		System.out.print(s);
		System.out.print(" Stack (bottom-->top) : ");
		for (int j = 0; j < theStack.size(); j++) {
			System.out.print(theStack.peekN(j));
			System.out.print(' ');
		}
		System.out.println("");
	}

}
