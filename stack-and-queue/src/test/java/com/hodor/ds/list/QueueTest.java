package com.hodor.ds.list;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> theQueue = new Queue<>(); // queue holds 5 items

		// insert 4 items
		theQueue.insert(20);
		theQueue.insert(15);
		theQueue.insert(25);
		theQueue.insert(10);

		// remove 3 items (20,15,25)
		theQueue.remove();
		theQueue.remove();
		theQueue.remove();

		// insert 4 more items (wrap around)
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.insert(50);
		theQueue.insert(60);

		// until its empty remove and display all the items
		while (!theQueue.isEmpty()) {
			Integer item = theQueue.remove();
			System.out.print(item + "  ");
		}

		System.out.println("");
		System.out.println("Queue empty : " + theQueue.isEmpty());
	}
}
