package com.corejava.arrays;

public class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 100;
		long pivot = 99;
		Partition partition = new Partition(maxSize);
		int nElems = 16;
		for (int i = 0; i < nElems; i++) {
			long n = (long) (Math.random() * 199);
			partition.insert(n);
		}
		partition.display();
		// return the partition position in the array:this is the index of the
		// first element in the right group
		System.out.println("Partition position:" + partition.partition(0, nElems - 1, pivot));
		partition.display();
	}
}
