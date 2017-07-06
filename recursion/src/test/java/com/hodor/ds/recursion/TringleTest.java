package com.hodor.ds.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hodor.ds.recursion.Tringle;

public class TringleTest {
	static int theNumber;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number:");
		theNumber = getInt();
		int answer = new Tringle().tringle(theNumber);
		System.out.println("Tringle = " + answer);
	}

	private static int getInt() throws IOException {
		String number = getString();
		return Integer.parseInt(number);
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}
}
