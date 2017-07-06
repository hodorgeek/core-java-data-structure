package com.hodor.ds.stack.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketCheckerTest {
	private static final BracketChecker bracketChecker = new BracketChecker();

	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.println("Enter string containing delimeter : ");
			input = getString();
			if (input.equals("")) { // quit if [Enter]
				break;
			}
			bracketChecker.check(input);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String str = br.readLine();
		return str;
	}
}
