package com.hodor.ds.stack.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixToPostfixTest {

	private static final InfixToPostfix INFIX_TO_POSTFIX = new InfixToPostfix();

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.println("Enter string containing delimeter : ");
			input = getString();
			if (input.equals("")) { // quit if [Enter]
				break;
			}
			output = INFIX_TO_POSTFIX.convert(input);
			System.out.println("The postfix expression is : " + output);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String str = br.readLine();
		return str;
	}
}
