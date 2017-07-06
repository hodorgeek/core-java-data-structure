package com.hodor.ds.stack.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverserTest {

	private static final StringReverser stringReverser = new StringReverser();

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.println("Enter the String : ");
			input = getString();
			if (input.equals("")) { // quit if [Enter]
				break;
			}
			output = stringReverser.revereString(input);
			System.out.println("Reverse String : " + output);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String str = br.readLine();
		return str;
	}
}
