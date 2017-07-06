package com.hodor.ds.queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQ priorityQ = new PriorityQ(5);
		priorityQ.insert(20);
		priorityQ.insert(5);
		priorityQ.insert(50);
		priorityQ.insert(60);
		priorityQ.insert(15);

		System.out.println("Queue Full : " + priorityQ.isFull());
		System.out.println("Peek element : " + priorityQ.peekMin());
		while (!priorityQ.isEmpty()) {
			System.out.print(priorityQ.remove() + "  ");
		}
		System.out.println("");
		System.out.println("Queue Empty : " + priorityQ.isEmpty());
	}
}
