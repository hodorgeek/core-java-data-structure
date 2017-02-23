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

		public Node(T value, Node<T> next) {
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

	public void add(T element) {
		addLast(element);
	}

	public void addFirst(T element) {
		if (isEmpty()) {
			addNodeInEmptyList(element);
		} else {
			Node<T> newNode = new Node<T>(element, first);
			first = newNode;
			size++;
		}
	}

	public void addLast(T element) {
		if (isEmpty()) {
			addNodeInEmptyList(element);
		} else {
			Node<T> newNode = new Node<T>();
			newNode.value = element;
			newNode.next = null;
			last.next = newNode;
			last = newNode;
			size++;
		}
	}

	public void add(int index, T element) {
		checkIndex(index);
		if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {
			Node<T> xNode, tempNode, newNode;
			tempNode = getNode(index - 1);
			xNode = tempNode.next;
			newNode = new Node<T>(element, xNode);
			tempNode.next = newNode;

			size++;
		}
	}

	public void add(T... elements) {
		for (T temp : elements) {
			addLast(temp);
		}
	}

	public void add(int index, T... elements) {
		if (elements == null || elements.length == 0) {
			return;
		} else if (index == 0 || index == size) {
			for (T temp : elements) {
				add(index, temp);
			}
		} else {
			// TODO:Need to implement/revisit this logic later
			Node<T> xNode, tempNode, newNode = null;
			tempNode = getNode(index - 1);
			xNode = tempNode.next;
			for (T element : elements) {
				newNode = new Node<T>(element, xNode);
			}
			tempNode.next = newNode;

			size++;
		}
	}

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

	public int size() {
		return size;
	}

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

	public boolean remove(T element) throws ElementNotFoundException {
		boolean found = false;
		if (!isEmpty()) {
			if (element.equals(first.value)) {
				found = true;
				removeFirst();
			} else if (element.equals(last.value)) {
				found = true;
				removeLast();
			} else {

				final Node<T> nodeBeforeElement = getNodeBeforeElement(element);
				if (nodeBeforeElement != null) {
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

	public T removeLast() {
		T element = null;

		if (!isEmpty()) {
			Node<T> nodeBeforeRemovedNode = first;
			while (nodeBeforeRemovedNode.next != null) {
				nodeBeforeRemovedNode = nodeBeforeRemovedNode.next;
			}
			Node<T> nodeToBeRemoved = last;
			last = nodeBeforeRemovedNode;
			element = nodeToBeRemoved.value;
			size--;
			nodeToBeRemoved = null;
		}

		return element;
	}

	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public void reverse() {
		// TODO Auto-generated method stub

	}

	public List<T> reverseList() {
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int index, T newElement) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		return first == null || last == null || size == 0;
	}

	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	public int indexOf(T element) {
		int indexOfFirstOcuurenceOfElement = -1;
		if (!isEmpty()) {
			Node<T> tempNode = first;
			int i = 0;
			while (tempNode != null) {
				if (tempNode.value.equals(element)) {
					indexOfFirstOcuurenceOfElement = i;
					break;
				}
				i++;
				tempNode = tempNode.next;
			}
		}
		return indexOfFirstOcuurenceOfElement;
	}

	public T get(int index) {
		Node<T> tempNode = getNode(index);
		return tempNode.value;
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new ListEmptyException(getIndexMessage(-1));
		}
		return first.value;
	}

	public T getLast() {
		if (isEmpty()) {
			throw new ListEmptyException(getIndexMessage(-1));
		}
		return last.value;
	}

	public int lastIndexOf(T element) {
		int indexOfLastOcuurenceOfElement = -1;
		if (!isEmpty()) {
			Node<T> tempNode = first;
			int i = 0;
			while (tempNode != null) {
				if (tempNode.value.equals(element)) {
					indexOfLastOcuurenceOfElement = i;
				}
				i++;
				tempNode = tempNode.next;
			}
		}
		return indexOfLastOcuurenceOfElement;
	}

	public Object[] toArray() {
		Object[] objArr = new Object[size];
		if (!isEmpty()) {
			int i = -1;
			for (Node<T> pNode = first; pNode.next != null; pNode = pNode.next) {
				objArr[++i] = pNode.value;
			}
		}
		return objArr;
	}

	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(getIndexMessage(index));
		}
	}

	private String getIndexMessage(int index) {
		return new StringBuilder("index = ").append(index).append(", size = ").append(size).toString();
	}

	private void addNodeInEmptyList(T element) {
		Node<T> newNode = new Node<T>(element, null);
		first = last = newNode;
		size++;
	}

	private Node<T> getNode(int index) {
		checkIndex(index);
		Node<T> tempNode = first;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	private Node<T> getNodeBeforeElement(final T element) {
		Node<T> nodeBeforeElement = null;
		if (!isEmpty()) {
			// Node<T> tempNode = first;
			for (Node<T> tempNode = first; tempNode.next != null; tempNode = tempNode.next) {
				if (element.equals(tempNode.value)) {
					nodeBeforeElement = tempNode;
					break;
				}
			}
		}
		return nodeBeforeElement;
	}
}
