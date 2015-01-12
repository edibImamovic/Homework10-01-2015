package com.bitcamp.homework;

/**
 * 
 * @author Edib Imamovic
 *
 */
public class SortedLinkedListInt {

	private int size;
	private Node head;
	private int[] array;

	/**
	 * Constructor for LinkedListInt
	 */
	public SortedLinkedListInt() {
		super();
		this.size = 0;
		this.head = null;
	}

	/**
	 * Constructor for LinkedListInt
	 * 
	 * @param size
	 * 
	 * @param head
	 * 
	 */
	public SortedLinkedListInt(int size, Node head) {

		this.size = size;
		this.head = head;
	}

	/**
	 * Method for adding new Node
	 * 
	 * @param value
	 * 
	 */
	public void add(int value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		if (head.value > newNode.value) {
			newNode.next = head;
			head = newNode;
			size++;
		} else if (head.value < newNode.value) {
			Node current = head.next;
			Node prev = head;
			while (current != null) {
				if (current.value > newNode.value) {
					break;
				}
				prev = current;
				current = current.next;
			}
			newNode.next = current;
			prev.next = newNode;
			size++;
		}

	}

	/**
	 * Method for selection sort
	 * 
	 * @param array
	 */
	private void selectionSort(int[] array) {
		int j;
		for (int i = 0; i < array.length - 1; i++) {
			int min = 1;
			for (j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

	}

	/**
	 * Method for add index at value
	 * 
	 * @param index
	 * 
	 * @param value
	 * 
	 */
	public void add(int index, int value) {
		Node newNode = new Node(value);

		if (index == 0) {
			head.next = head;
			head = newNode;
			size++;
			return;
		}

		Node current = head.next;
		Node prev = head;
		int counter = 1;

		while (counter < index) {
			prev = prev.next;
			current = current.next;
			counter++;
		}

		prev.next = newNode;
		newNode.next = current;
		size++;

	}

	/**
	 * Method for remove node at index
	 * 
	 * @param index
	 *            -
	 */
	public void remove(int index) {
		Node current = head;
		if (index == 0) {
			head = current.next;
			current = null;
			size--;
			return;
		}

		current = head.next;
		Node prev = head;
		int counter = 1;
		while (counter < index) {
			prev = prev.next;
			current = current.next;
			counter++;
		}
		prev.next = current.next;
		current = null;
		size--;

	}

	/**
	 * Getter for size of linked list.
	 * 
	 * @return size of linked list.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method for contains
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		boolean contains = false;

		Node current = head;
		while (current != null) {
			if (current.value == value) {
				return true;
			}
			current = current.next;

		}
		return contains;
	}

	/**
	 * Method for toString
	 */
	public String toString() {
		String str = "";
		str = "[ ";
		Node current = head;
		while (current != null) {
			str += current.value;
			current = current.next;
			if (current != null) {
				str += ", ";
			}
		}
		str += " ]";
		return str;

	}

	/**
	 * Class for creating Node next and value.
	 * 
	 * @author Edib Imamovic
	 *
	 */
	private class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}

		/**
		 * Getter for value
		 * 
		 * @return
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Getter for next Node
		 * 
		 * @return
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Setter for Next Node
		 * 
		 * @param other
		 */
		public void setNext(Node other) {
			this.next = other.next;
		}
	}

}
