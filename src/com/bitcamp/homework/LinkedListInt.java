package com.bitcamp.homework;

/**
 * 
 * @author Edib Imamovic
 *
 */
public class LinkedListInt {

	Node head;
	int size;

	public LinkedListInt() {
		head = null;
		size = 0;
	}

	/**
	 * Method for adding node
	 * 
	 * @param value
	 */
	public void add(int value) {

		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			size++;
		} else {
			Node current = head;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = newNode;
			size++;
		}

	}

	/**
	 * Method toString
	 */
	public String toString() {
		String str = "";
		Node current = head;
		while (current != null) {
			str += current.value + " ";
			current = current.nextNode;
		}
		return str;

	}

	/**
	 * Class for creating new Node and value.
	 * 
	 * @author Edib Imamovic
	 *
	 */
	private class Node {

		public int value;
		public Node nextNode;

		public Node(int value) {
			this.value = value;
			nextNode = null;

		}
	}

	/**
	 * Method for removing node.
	 * 
	 * @param index
	 * @throws new
	 *             index out of bounce exeption.
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Size is not valid");
		}
		if (index == 0) {
			head = head.nextNode;
			size--;
			return;
		}
		Node current = head.nextNode;
		Node previous = head;
		int counter = 1;

		while (counter < index) {
			current = current.nextNode;
			previous = previous.nextNode;
			counter++;
		}

		previous.nextNode = current.nextNode;
		current.nextNode = null;
		size--;
	}

	/**
	 * Method for adding node value to selected index
	 * 
	 * @param value
	 * @param index
	 * @throws new
	 *             illegal exception with message.
	 */
	public void add(int value, int index) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Size is not valid");
		}

		Node newNode = new Node(value);
		if (index == 0) {
			head = newNode;
			size++;
		} else {
			Node current = head.nextNode;
			Node previuos = head;
			int counter = 1;

			while (counter < index) {
				current = current.nextNode;
				previuos = previuos.nextNode;
				counter++;
			}
			previuos.nextNode = newNode;
			newNode.nextNode = current;
			size++;
		}

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
	 * Method contains for checking if array contain input value.
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
			current = current.nextNode;

		}
		return contains;
	}

}