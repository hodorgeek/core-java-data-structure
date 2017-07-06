package com.hodor.ds.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
	static int size = 0;
	static int count = 0;
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a word:"); // get word
		String input = getString();
		size = input.length();
		for (int j = 0; j < size; j++)
			arrChar[j] = input.charAt(j);

		doAnagram(size); // anagram it
	}

	public static void doAnagram(final int newSize) {
		if (newSize == 1) // if too small
			return; // go no further
		for (int j = 0; j < newSize; j++) { // for each iteration

			doAnagram(newSize - 1); // anagram remaining

			if (newSize == 2) { // if innermost display it
				displayWord();
			}

			rotate(newSize); // rotate whole word
		}
	}

	// rotate left chars from position to end
	private static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position]; // save first character
		for (j = position + 1; j < size; j++) { // shift others left
			arrChar[j - 1] = arrChar[j];
		}
		arrChar[j - 1] = temp; // put first on right
	}

	private static void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");
		for (int j = 0; j < size; j++) {
			System.out.print(arrChar[j]);
		}
		System.out.print("  ");
		if (count % 6 == 0) {
			System.out.println("");
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
