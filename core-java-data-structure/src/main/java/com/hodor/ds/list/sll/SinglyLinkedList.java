package com.hodor.ds.list.sll;

import com.hodor.ds.list.List;
import com.hodor.ds.list.exceptions.ElementNotFoundException;
import com.hodor.ds.list.exceptions.ListEmptyException;

/**
 * This class creates the singly linked list and provides implementation of
 * various operations of the list like add, remove etc.
 * 
 * @author sham
 *
 * @param <T>
 *            defined the type of the the singly linked list
 */
public class SinglyLinkedList<T> implements List<T> {

	/**
	 * The static inner class defines the structure of the linked list Node
	 *
	 * @param <T>
	 *            the type of the Node
	 */
	private static class Node<T> {
		T value;
		Node<T> next;

		public Node() {
		}

		public Node(final T value, final Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	/**
	 * It holds reference to the first/head/start node of the singly linked list
	 */
	private Node<T> first;

	/**
	 * It holds reference to the last/tail/end node of the singly linked list
	 */
	private Node<T> last;

	/**
	 * It is used to keep the track to size of the linked list. After adding or
	 * removing each node to/from the list this variable get increment or
	 * decrement
	 */
	private int size;

	public SinglyLinkedList() {
		// default constructor
	}

	@Override
	public void add(final T element) {
		addLast(element);
	}

	@Override
	public void addFirst(final T element) {
		if (isEmpty()) {
			addNodeInEmptyList(element);
		} else {
			final Node<T> newNode = new Node<T>(element, first);
			first = newNode;
			size++;
		}
	}

	@Override
	public void addLast(final T element) {
		if (isEmpty()) {
			addNodeInEmptyList(element);
		} else {
			final Node<T> newNode = new Node<T>();
			newNode.value = element;
			newNode.next = null;
			last.next = newNode;
			last = newNode;
			size++;
		}
	}

	@Override
	public void add(final int index, final T element) {
		checkPositionIndex(index);
		if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {
			Node<T> xNode, tempNode, newNode;
			tempNode = getNodeByIndex(index - 1);
			xNode = tempNode.next;
			newNode = new Node<T>(element, xNode);
			tempNode.next = newNode;
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addElements(final T... elements) {
		for (final T temp : elements) {
			addLast(temp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addElements(final int index, final T... elements) {
		if (elements == null || elements.length == 0) {
			return;
		} else if (index == 0 || index == size) {
			for (final T temp : elements) {
				add(index, temp);
			}
		} else {
			// TODO:Need to implement/revisit this logic later
			Node<T> xNode, tempNode, newNode = null;
			tempNode = getNodeByIndex(index - 1);
			xNode = tempNode.next;
			for (final T element : elements) {
				newNode = new Node<T>(element, xNode);
			}
			tempNode.next = newNode;

			size++;
		}
	}

	@Override
	public void printList() {
		Node<T> tempNode = first;
		if (tempNode == null) {
			System.out.println("-->" + null);
		} else {
			while (tempNode.next != null) {
				System.out.print("-->" + tempNode.value);
				tempNode = tempNode.next;
			}
			System.out.println("-->" + tempNode.value + "-->" + null);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	@SuppressWarnings("unused")
	public void clear() {
		if (isEmpty()) {
			return;
		} else {
			Node<T> pNode, qNode;
			pNode = qNode = first;
			while (pNode != null) {
				qNode = pNode;
				pNode = pNode.next;
				qNode = null;
			}
			first = last = null;
			size = 0;
		}
	}

	@Override
	public boolean remove(final T element) throws ElementNotFoundException {
		boolean found = false;
		if (!isEmpty()) {
			if ((element != null && element.equals(first.value) || (element == null && element == first.value))) {
				found = true;
				removeFirst();
			} else if ((element != null && element.equals(last.value) || (element == null && element == last.value))) {
				found = true;
				removeLast();
			} else {

				final Node<T> nodeBeforeElement = getNodeBeforeElement(element);
				if (nodeBeforeElement != null) {
					System.out.println("The node before element is : " + nodeBeforeElement.value);
					found = true;
					Node<T> nodeToBeRemoved = nodeBeforeElement.next;
					final Node<T> nodeAfterElement = nodeToBeRemoved.next;
					nodeBeforeElement.next = nodeAfterElement;
					size--;
					nodeToBeRemoved = null;
				}
			}
		}

		if (!found) {
			throw new ElementNotFoundException("Element : " + element + " is not found in the list");
		}
		return found;
	}

	@Override
	public T removeFirst() {
		T element = null;
		if (!isEmpty()) {
			Node<T> nodeToBeRemoved = first;
			first = first.next;
			element = nodeToBeRemoved.value;
			size--;
			nodeToBeRemoved = null;
		} else {
			throw new ListEmptyException("Empty list, size : " + size);
		}
		return element;
	}

	@Override
	public T removeLast() {
		T element = null;

		if (!isEmpty()) {
			Node<T> nodeBeforeLastNode = first;
			Node<T> tempNode = first;
			while (tempNode.next != null) {
				nodeBeforeLastNode = tempNode;
				tempNode = tempNode.next;
			}
			final Node<T> nodeToBeRemoved = last;
			element = nodeToBeRemoved.value;
			nodeToBeRemoved.next = null;
			nodeToBeRemoved.value = null;
			last = nodeBeforeLastNode;
			last.next = null;
			size--;
		} else {
			throw new ListEmptyException("Empty list, size : " + size);
		}
		return element;
	}

	@Override
	public T remove(final int index) {
		checkElementIndex(index);
		T removedElement = null;
		if (index == 0) {
			removedElement = removeFirst();
		} else if (index == size - 1) {
			removedElement = removeLast();
		} else {
			final Node<T> nodeBeforeRemovedNode = getNodeByIndex(index - 1);
			final Node<T> nodeToBeRemoved = nodeBeforeRemovedNode.next;
			final Node<T> nodeAfterRemovedNode = nodeToBeRemoved.next;
			nodeBeforeRemovedNode.next = nodeAfterRemovedNode;
			removedElement = nodeToBeRemoved.value;
			nodeToBeRemoved.next = null;
			nodeToBeRemoved.value = null;
			size--;
		}
		return removedElement;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<T> reverseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(final int index, final T newElement) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return first == null || last == null || size == 0;
	}

	@Override
	public boolean contains(final T element) {
		return indexOf(element) != -1;
	}

	@Override
	public int indexOf(final T element) {
		int indexOfFirstOcuurenceOfElement = -1;
		if (!isEmpty()) {
			Node<T> tempNode = first;
			int i = 0;
			while (tempNode != null) {
				if (tempNode.value == null) {
					if (element == tempNode.value) {
						indexOfFirstOcuurenceOfElement = i;
						break;
					}
				} else {
					if (tempNode.value.equals(element)) {
						indexOfFirstOcuurenceOfElement = i;
						break;
					}
				}
				i++;
				tempNode = tempNode.next;
			}

		}
		return indexOfFirstOcuurenceOfElement;
	}

	@Override
	public T get(final int index) {
		checkElementIndex(index);
		final Node<T> tempNode = getNodeByIndex(index);
		return tempNode.value;
	}

	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new ListEmptyException(getIndexMessage(-1));
		}
		return first.value;
	}

	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new ListEmptyException(getIndexMessage(-1));
		}
		return last.value;
	}

	@Override
	public int lastIndexOf(final T element) {
		int indexOfLastOcurrenceOfElement = -1;
		if (!isEmpty()) {
			Node<T> tempNode = first;
			int i = 0;
			while (tempNode != null) {
				if (tempNode.value == null) {
					if (element == tempNode.value) {
						indexOfLastOcurrenceOfElement = i;
					}
				} else {
					if (tempNode.value.equals(element)) {
						indexOfLastOcurrenceOfElement = i;
					}
				}
				i++;
				tempNode = tempNode.next;
			}
		}
		return indexOfLastOcurrenceOfElement;
	}

	@Override
	public Object[] toArray() {
		final Object[] objArr = new Object[size];
		if (!isEmpty()) {
			int i = -1;
			Node<T> pNode = first;
			for (; pNode.next != null; pNode = pNode.next) {
				objArr[++i] = pNode.value;
			}
			objArr[++i] = pNode.value;
		}
		return objArr;
	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	private boolean isElementIndex(final int index) {
		return index >= 0 && index < size;
	}

	/**
	 * Tells if the argument is the index of a valid position for an iterator or
	 * an add operation.
	 */
	private boolean isPositionIndex(final int index) {
		return index >= 0 && index <= size;
	}

	private void checkElementIndex(final int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(getIndexMessage(index));
	}

	private void checkPositionIndex(final int index) {
		if (!isPositionIndex(index))
			throw new IndexOutOfBoundsException(getIndexMessage(index));
	}

	private String getIndexMessage(final int index) {
		return new StringBuilder("index : ").append(index).append(", size : ").append(size).toString();
	}

	private void addNodeInEmptyList(final T element) {
		final Node<T> newNode = new Node<T>(element, null);
		first = last = newNode;
		size++;
	}

	private Node<T> getNodeByIndex(final int index) {
		Node<T> tempNode = first;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	private Node<T> getNodeBeforeElement(final T element) {
		Node<T> nodeBeforeElement = null;
		boolean found = false;
		if (!isEmpty()) {
			// To handle the null value
			if (element == null) {
				for (Node<T> tempNode = first; tempNode.next != null; tempNode = tempNode.next) {
					if (element == tempNode.value) {
						found = true;
						break;
					}
					nodeBeforeElement = tempNode;
				}
			} else {
				for (Node<T> tempNode = first; tempNode.next != null; tempNode = tempNode.next) {
					if (element.equals(tempNode.value)) {
						found = true;
						break;
					}
					nodeBeforeElement = tempNode;
				}
			}
		}
		if (!found) {
			nodeBeforeElement = null;
		}
		return nodeBeforeElement;
	}
}
