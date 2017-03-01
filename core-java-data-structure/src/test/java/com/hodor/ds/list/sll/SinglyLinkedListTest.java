package com.hodor.ds.list.sll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hodor.ds.list.List;
import com.hodor.ds.list.exceptions.ElementNotFoundException;
import com.hodor.ds.list.exceptions.ListEmptyException;

/**
 * Unit test cases for SinglyLinkedList<T>
 */
public class SinglyLinkedListTest {

	private SinglyLinkedList<Integer> mySinglyLinkedList;

	private SinglyLinkedList<String> myStringSinglyLinkedList;

	private static final String SIZE_MESSAGE = "The SLL size should be ";

	private static final String DELETE_MESSAGE = "The removed element must be ";

	private static final String CONTAINS_MESSAGE = "The element still is present in the list : ";

	private static final String INDEX_OF_MESSAGE = "The index of the element should be ";

	private static final String TO_ARRAY_MESSAGE = "The elements should be ";

	private static final String GET_ELEMENT_MESSAGE = "The retrived element should be ";

	private static final String REPLACED_ELEMENT_MESSAGE = "The replaced element must be ";

	@Before
	public void setUp() {
		mySinglyLinkedList = new SinglyLinkedList<Integer>();
		myStringSinglyLinkedList = new SinglyLinkedList<String>();
	}

	@Test
	public void testAddElementToSll() {
		mySinglyLinkedList.add(20);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.add(25);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySinglyLinkedList.size());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddElementAtToSll() {
		mySinglyLinkedList.add(0, 10);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
		mySinglyLinkedList.add(1, 20);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySinglyLinkedList.size());
		mySinglyLinkedList.add(1, 30);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySinglyLinkedList.size());
		mySinglyLinkedList.add(3, 40);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySinglyLinkedList.size());
		mySinglyLinkedList.add(0, 5);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySinglyLinkedList.size());
		mySinglyLinkedList.add(3, 35);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySinglyLinkedList.size());
		mySinglyLinkedList.add(5, 38);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 7), 7, mySinglyLinkedList.size());
		mySinglyLinkedList.add(8, 50);
		mySinglyLinkedList.printList();
	}

	@Test(expected = ListEmptyException.class)
	public void testGetFirstElement() {
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(20);
		Assert.assertEquals("The first element should be 10", new Integer(10), mySinglyLinkedList.getFirst());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySinglyLinkedList.size());
		mySinglyLinkedList.printList();
		mySinglyLinkedList.clear();
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), mySinglyLinkedList.getFirst());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
	}

	@Test
	public void testPrintSinglyLinkedList() {
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySinglyLinkedList.size());
		mySinglyLinkedList.printList();
	}

	@Test
	public void testPrintSinglyLinkedListWhenListIsEmpty() {
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySinglyLinkedList.size());
		mySinglyLinkedList.printList();
	}

	@Test(expected = ElementNotFoundException.class)
	public void testRemoveSpecifiedElement() {
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySinglyLinkedList.size());
		boolean result = mySinglyLinkedList.remove(new Integer(50));
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 50), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 50), mySinglyLinkedList.contains(50));
		result = mySinglyLinkedList.remove(new Integer(20));
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 20), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 20), mySinglyLinkedList.contains(20));

		result = mySinglyLinkedList.remove(new Integer(30));
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 30), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 30), mySinglyLinkedList.contains(30));

		result = mySinglyLinkedList.remove(new Integer(40));
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 40), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 40), mySinglyLinkedList.contains(40));

		result = mySinglyLinkedList.remove(new Integer(10));
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 10), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 10), mySinglyLinkedList.contains(10));
		result = mySinglyLinkedList.remove(new Integer(40));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveElementAt() {
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);

		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySinglyLinkedList.size());
		mySinglyLinkedList.printList();

		Integer result = mySinglyLinkedList.remove(1);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 50), mySinglyLinkedList.contains(50));

		result = mySinglyLinkedList.remove(0);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 10), mySinglyLinkedList.contains(10));

		result = mySinglyLinkedList.remove(3);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 40), new Integer(40), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 40), mySinglyLinkedList.contains(40));

		mySinglyLinkedList.printList();
		result = mySinglyLinkedList.remove(3);
	}

	@Test(expected = ListEmptyException.class)
	public void testRemoveFirstElement() {
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySinglyLinkedList.size());
		Integer result = mySinglyLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		result = mySinglyLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		mySinglyLinkedList.printList();
		result = mySinglyLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 60), new Integer(60), result);
		System.out.println(mySinglyLinkedList.isEmpty());
		Assert.assertTrue("The list should be empty", mySinglyLinkedList.isEmpty());
		mySinglyLinkedList.printList();
		mySinglyLinkedList.removeFirst();
	}

	@Test(expected = ListEmptyException.class)
	public void testRemoveLastElement() {
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.printList();

		Integer result = mySinglyLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 20), new Integer(20), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 20), mySinglyLinkedList.contains(20));
		Assert.assertTrue("The list should be empty", mySinglyLinkedList.isEmpty());

		mySinglyLinkedList.printList();
		mySinglyLinkedList.add(10);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		mySinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySinglyLinkedList.size());

		result = mySinglyLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 60), new Integer(60), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 60), mySinglyLinkedList.contains(60));
		mySinglyLinkedList.printList();

		result = mySinglyLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 50), mySinglyLinkedList.contains(50));
		mySinglyLinkedList.printList();

		result = mySinglyLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 10), mySinglyLinkedList.contains(10));
		Assert.assertTrue("The list should be empty", mySinglyLinkedList.isEmpty());
		mySinglyLinkedList.printList();

		mySinglyLinkedList.removeLast();
	}

	@Test
	public void testIndexOf() {
		mySinglyLinkedList.add(0, null);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.add(8, null);

		Assert.assertEquals(getMessage(SIZE_MESSAGE, 9), 9, mySinglyLinkedList.size());
		int index = mySinglyLinkedList.indexOf(50);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 1), 1, index);
		index = mySinglyLinkedList.indexOf(20);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 4), 4, index);
		index = mySinglyLinkedList.indexOf(40);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 7), 7, index);
		index = mySinglyLinkedList.indexOf(null);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, null), 0, index);
		index = mySinglyLinkedList.indexOf(10);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, -1), -1, index);
		mySinglyLinkedList.printList();
	}

	@Test
	public void testLastIndexOf() {
		mySinglyLinkedList.add(null);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.add(null);

		Assert.assertEquals(getMessage(SIZE_MESSAGE, 9), 9, mySinglyLinkedList.size());
		int index = mySinglyLinkedList.lastIndexOf(50);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 3), 3, index);
		index = mySinglyLinkedList.lastIndexOf(20);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 5), 5, index);
		index = mySinglyLinkedList.lastIndexOf(40);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 7), 7, index);
		index = mySinglyLinkedList.lastIndexOf(null);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, 8), 8, index);
		index = mySinglyLinkedList.lastIndexOf(10);
		Assert.assertEquals(getMessage(INDEX_OF_MESSAGE, -1), -1, index);
		mySinglyLinkedList.printList();
	}

	@Test
	public void testToObjectArray() {
		mySinglyLinkedList.add(10);

		Object[] actualObjectArray = mySinglyLinkedList.toArray();

		Assert.assertEquals(getMessage(SIZE_MESSAGE, actualObjectArray.length), actualObjectArray.length,
				mySinglyLinkedList.size());

		Object expectedObjectArray[] = new Object[] { 10 };
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				actualObjectArray);

		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.add(50);
		mySinglyLinkedList.add(60);
		mySinglyLinkedList.add(70);
		mySinglyLinkedList.add(null);
		mySinglyLinkedList.addFirst(null);

		actualObjectArray = mySinglyLinkedList.toArray();

		Assert.assertEquals(getMessage(SIZE_MESSAGE, actualObjectArray.length), actualObjectArray.length,
				mySinglyLinkedList.size());

		expectedObjectArray = new Object[] { null, 10, 20, 30, 40, 50, 60, 70, null };
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				actualObjectArray);

		mySinglyLinkedList.clear();
		actualObjectArray = mySinglyLinkedList.toArray();
		expectedObjectArray = new Object[mySinglyLinkedList.size()];
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				actualObjectArray);
	}

	@Test
	public void testSLLOperationsForNullValue() {
		myStringSinglyLinkedList.add("john");
		myStringSinglyLinkedList.add(null);
		myStringSinglyLinkedList.addFirst("brayan");
		myStringSinglyLinkedList.addFirst(null);
		myStringSinglyLinkedList.add(0, "sham");
		myStringSinglyLinkedList.add(1, null);
		myStringSinglyLinkedList.addFirst(null);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 7), 7, myStringSinglyLinkedList.size());
		String result = myStringSinglyLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, myStringSinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, null), null, result);
		result = myStringSinglyLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, myStringSinglyLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, null), null, result);
		boolean isRemoved = myStringSinglyLinkedList.remove(null);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, myStringSinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, null), isRemoved);
		result = myStringSinglyLinkedList.remove(1);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, myStringSinglyLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, null), isRemoved);
		myStringSinglyLinkedList.printList();
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, null), myStringSinglyLinkedList.contains(null));

		myStringSinglyLinkedList.printList();
	}

	@Test
	public void testGetElementByIndex() {
		myStringSinglyLinkedList.add("john");
		myStringSinglyLinkedList.add(null);
		myStringSinglyLinkedList.addFirst("brayan");
		myStringSinglyLinkedList.addFirst(null);
		myStringSinglyLinkedList.add(0, "sham");
		myStringSinglyLinkedList.add(1, null);
		myStringSinglyLinkedList.addFirst(null);
		myStringSinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 7), 7, myStringSinglyLinkedList.size());
		String actualResult = myStringSinglyLinkedList.get(0);
		Assert.assertEquals(getMessage(GET_ELEMENT_MESSAGE, null), null, actualResult);
		actualResult = myStringSinglyLinkedList.get(2);
		Assert.assertEquals(getMessage(GET_ELEMENT_MESSAGE, null), null, actualResult);
		actualResult = myStringSinglyLinkedList.get(5);
		Assert.assertEquals(getMessage(GET_ELEMENT_MESSAGE, "john"), "john", actualResult);
	}

	@Test
	public void testSetElementToIndex() {
		myStringSinglyLinkedList.add("john");
		myStringSinglyLinkedList.add(null);
		myStringSinglyLinkedList.addFirst("brayan");
		myStringSinglyLinkedList.addFirst(null);
		myStringSinglyLinkedList.add(0, "sham");
		myStringSinglyLinkedList.add(1, null);
		myStringSinglyLinkedList.addFirst(null);

		myStringSinglyLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 7), 7, myStringSinglyLinkedList.size());
		String replacedElement = myStringSinglyLinkedList.set(0, "sansa");
		Assert.assertEquals(getMessage(REPLACED_ELEMENT_MESSAGE, replacedElement), null, replacedElement);

		replacedElement = myStringSinglyLinkedList.set(2, "arya");
		Assert.assertEquals(REPLACED_ELEMENT_MESSAGE, null, replacedElement);
		myStringSinglyLinkedList.printList();

		replacedElement = myStringSinglyLinkedList.set(3, "cersi");
		Assert.assertEquals(REPLACED_ELEMENT_MESSAGE, null, replacedElement);

		replacedElement = myStringSinglyLinkedList.set(6, "Tyrwin");
		Assert.assertEquals(REPLACED_ELEMENT_MESSAGE, null, replacedElement);
		Assert.assertFalse(CONTAINS_MESSAGE, myStringSinglyLinkedList.contains(null));
		myStringSinglyLinkedList.printList();
	}

	@Test
	public void testReverse() {
		myStringSinglyLinkedList.reverse();

		myStringSinglyLinkedList.add("john");
		myStringSinglyLinkedList.reverse();
		Assert.assertEquals("john", myStringSinglyLinkedList.getFirst());
		Assert.assertEquals("john", myStringSinglyLinkedList.getLast());

		myStringSinglyLinkedList.addFirst("brayan");
		myStringSinglyLinkedList.add(0, "sham");
		myStringSinglyLinkedList.add(1, "sansa");
		myStringSinglyLinkedList.addFirst("arya");
		myStringSinglyLinkedList.printList();
		Assert.assertEquals("arya", myStringSinglyLinkedList.getFirst());
		Assert.assertEquals("john", myStringSinglyLinkedList.getLast());

		myStringSinglyLinkedList.reverse();
		myStringSinglyLinkedList.printList();
		Assert.assertEquals("john", myStringSinglyLinkedList.getFirst());
		Assert.assertEquals("arya", myStringSinglyLinkedList.getLast());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, myStringSinglyLinkedList.size());

		myStringSinglyLinkedList.clear();
		myStringSinglyLinkedList.add("jemmi");
		myStringSinglyLinkedList.add("theon");
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, myStringSinglyLinkedList.size());
		Assert.assertEquals("jemmi", myStringSinglyLinkedList.getFirst());
		Assert.assertEquals("theon", myStringSinglyLinkedList.getLast());
		myStringSinglyLinkedList.printList();
		myStringSinglyLinkedList.reverse();
		myStringSinglyLinkedList.printList();
		Assert.assertEquals("theon", myStringSinglyLinkedList.getFirst());
		Assert.assertEquals("jemmi", myStringSinglyLinkedList.getLast());
	}

	@Test
	public void testReverseList() {
		Object[] expectedObjectArray = new Object[mySinglyLinkedList.size()];

		Assert.assertEquals(getMessage(SIZE_MESSAGE, expectedObjectArray.length), expectedObjectArray.length,
				mySinglyLinkedList.size());
		// Test case 1 : When the list is empty
		List<Integer> reverseList = mySinglyLinkedList.reverseList();
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				reverseList.toArray());

		mySinglyLinkedList.add(10);

		expectedObjectArray = new Object[] { 10 };

		Assert.assertEquals(getMessage(SIZE_MESSAGE, expectedObjectArray.length), expectedObjectArray.length,
				mySinglyLinkedList.size());
		// Test case 2 : When the list contains only one element
		reverseList = mySinglyLinkedList.reverseList();
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				reverseList.toArray());
		Assert.assertEquals(new Integer(10), reverseList.getFirst());
		Assert.assertEquals(new Integer(10), reverseList.getLast());

		mySinglyLinkedList.add(20);
		mySinglyLinkedList.add(30);
		mySinglyLinkedList.add(40);
		mySinglyLinkedList.add(50);

		expectedObjectArray = new Object[] { 50, 40, 30, 20, 10 };

		Assert.assertEquals(new Integer(10), mySinglyLinkedList.getFirst());
		Assert.assertEquals(new Integer(50), mySinglyLinkedList.getLast());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, expectedObjectArray.length), expectedObjectArray.length,
				mySinglyLinkedList.size());

		// Test case 3 : When the list contains more than one elements
		reverseList = mySinglyLinkedList.reverseList();
		Assert.assertArrayEquals(getMessage(TO_ARRAY_MESSAGE, expectedObjectArray), expectedObjectArray,
				reverseList.toArray());
		Assert.assertEquals(new Integer(50), reverseList.getFirst());
		Assert.assertEquals(new Integer(10), reverseList.getLast());
	}

	private String getMessage(final String message, final Object object) {
		return new StringBuilder().append(message).append(object).toString();
	}
}
