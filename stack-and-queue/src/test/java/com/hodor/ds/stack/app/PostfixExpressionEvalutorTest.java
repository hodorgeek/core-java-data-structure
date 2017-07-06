package com.hodor.ds.stack.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixExpressionEvalutorTest {
	private static final PostfixExpressionEvalutor POSTFIX_EXPRESSION_EVALUTOR = new PostfixExpressionEvalutor();

	public static void main(String[] args) throws IOException {
		String input;
		Integer output;
		while (true) {
			System.out.println("Enter postfix expression containing number: ");
			input = getString();
			if (input.equals("")) { // quit if [Enter]
				break;
			}
			output = POSTFIX_EXPRESSION_EVALUTOR.evaluate(input);
			System.out.println("Evaluates to : " + output);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String str = br.readLine();
		return str;
	}
}
