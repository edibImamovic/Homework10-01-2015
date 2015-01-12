package com.bitcamp.homework;

/**
 * @author Edib Imamovic
 *
 */
public class DynamicArrayInt {

	int[] array;
	int size;
	private final int DEFAULT_SIZE = 10;
	int counter;

	/**
	 * Constructor with default size.
	 */

	public DynamicArrayInt() {

		size = 0;
		array = new int[DEFAULT_SIZE];
		counter = 0;
	}

	/**
	 * Method for add value to array.
	 * 
	 * @param value
	 */

	public void add(int value) {
		if (size == array.length) {
			resize();
		}
		array[size] = value;
		size++;
	}

	/**
	 * Method for array resize.
	 */
	private void resize() {

		int[] result = new int[array.length * 2];

		for (int i = 0; i < array.length; i++) {

			result[i] = array[i];
		}

		array = result;
	}

	/**
	 * Getter for size.
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method for toString
	 */

	public String toString() {
		String str = "";

		for (int i = 0; i < size; i++) {
			str += array[i] + " ";
		}

		return str;

	}

	/**
	 * Method for removing index value
	 * 
	 * @param index
	 * @throws new
	 *             exception with message
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Size is not valid");
		}

		for (int i = index; i < size; i++) {
			array[i] = array[i - 1];
		}
		size--;

	}

	/**
	 * Method for adding value to selected index.
	 * 
	 * @param value
	 * @param index
	 */
	public void add(int value, int index) {
		for (int i = size; i < index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = value;
		size++;

	}

	/**
	 * Method contains for checking if array contain input value.
	 * 
	 * @param value
	 * @return boolean value.
	 */
	public boolean contains(int value) {
		boolean contains = false;
		for (int i = 0; i < counter; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return contains;

	}

}
