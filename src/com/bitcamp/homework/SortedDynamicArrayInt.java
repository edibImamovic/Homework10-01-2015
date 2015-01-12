package com.bitcamp.homework;

/**
 * 
 * @author Edib Imamovic
 *
 */
public class SortedDynamicArrayInt {

	private int[] array;
	private int size;
	private final int DEFAULT_SIZE = 10;
	int counter = 0;

	/**
	 * Constructor for SortedDynamicArrayInt
	 */
	public SortedDynamicArrayInt() {
		this.array = new int[DEFAULT_SIZE];
		this.counter = 0;
	}

	/**
	 * Constructor for SortedDynamicArrayInt
	 * 
	 * @param size
	 *            - size of array.
	 */
	public SortedDynamicArrayInt(int size) {
		this.array = new int[size];
		this.counter = 0;

	}

	/**
	 * Method for adding value to array
	 * 
	 * @param value
	 *            .
	 */
	public void add(int value) {
		if (counter == array.length) {
			resize();
		}

		array[counter] = value;
		counter++;
		insertionSort(array);

	}

	/**
	 * Method for insertionSort
	 * 
	 * @param array
	 */
	private void insertionSort(int[] array) {
		for (int i = 0; i < counter; i++) {
			int currentNum = array[i];
			int j = i;

			for (j = i; j > 0 && currentNum < array[j - 1]; j--) {
				array[j] = array[j - 1];
			}
			array[j] = currentNum;
		}

	}

	/**
	 * Method that adds value in array of index .
	 * 
	 * @param index
	 * @param value
	 */
	public void add(int index, int value) {
		if (counter == size) {
			resize();
		}
		for (int i = counter + 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = value;
		counter++;
		insertionSort(array);
	}

	/**
	 * Method for resize.
	 */
	private void resize() {
		int[] temp = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		this.array = temp;
	}

	/**
	 * Method that removes element from index.
	 * 
	 * @param index
	 */
	public void remove(int index) {
		for (int i = index; i < counter; i++) {
			array[i] = array[i + 1];
		}
		counter--;
	}

	/**
	 * Method that counts number of elements in array.
	 * 
	 * @return - number of elements in array.
	 */
	public int getSize() {
		return counter;
	}

	/**
	 * Method that checks if array contains value.
	 * 
	 * @param value
	 * @return
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

	/**
	 * Method toString
	 */
	public String toString() {
		String str = "";
		str += "[";
		for (int i = 0; i < counter; i++) {
			str += array[i];
			if (i != counter - 1) {
				str += ", ";
			}
		}
		str += "]";

		return str;
	}

}
