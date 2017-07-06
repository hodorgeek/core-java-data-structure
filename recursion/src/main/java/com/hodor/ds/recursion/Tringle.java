package com.hodor.ds.recursion;

public class Tringle {

	public int tringle(final int n) {
		if (n == 1)
			return 1;
		else
			return (n + tringle(n - 1));
	}
}
