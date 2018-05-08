/**
 * CSC115 Assignment 2 : Containers
 * IntegerArrayList.java
 * Created for use by CSC115 Fall2015
 */

/*
 * NOTE TO PROGRAMMWE:
 * Do not alter this file.
 * It's purpose is to provide a comparison between a List 
 * that uses an array and a list that uses a linked data structure.
 */

/*
 * The IntegerArrayList is a list that uses an array as
 * the storage for its integers.
 */
public class IntegerArrayList implements IntegerList {

	private static final int INITIAL_SIZE=2;
	private int[] storage;
	private int count;

	/**
 	 * Creates and initializes an empty IntegerList.
 	 */
	public IntegerArrayList() {
		storage = new int[INITIAL_SIZE];
		count = 0;
	}

	/**
	 * A private method for use within this file only.
	 * This doubles the size of the storage array.
	 */
	private void growAndCopy() {
		int[] newStorage = new int[storage.length*2];
		// Move all the integers from storage into newStorage
		for (int i=0; i<count; i++) {
			newStorage[i] = storage[i];
		}
		storage = newStorage;
	}

	/**
 	 * A private helper method that moves all the elements after 
	 * position the given index, one position to the left.
 	 * @param fromIndex The index position where the sliding begins.
 	 */
	private void slideLeftFrom(int fromIndex) {
		for (int i=fromIndex; i<count-1; i++) {
			storage[i] = storage[i+1];;
		}
		count--;
	}

	/*
	 * IntegerList Interface methods...
	 * NOTE THAT THESE do not need header comments. They use 
	 * the comments from the IntegerList interface.
	 */

	public void insertFirst(int k) {
		if (count==storage.length) {
			growAndCopy();
		}
		// move everything over one to make room.
		for (int i=count; i>0; i--) {
			storage[i] = storage[i-1];
		}
		storage[0] = k;
		count++;
	}

	public void insertLast(int k) {
		if (count==storage.length) {
			growAndCopy();
		}
		storage[count++] = k;
	}

	public int size() {
		return count;
	}

	public int get(int pos) {
		// We could check to make sure that pos is correct, but
		// the method comments do warn the user of this method.
		// If they don't provide a valid value for pos, then the program will crash.
		return storage[pos];
	}

	public void removeAll() {
		count = 0;
	}

	public void remove(int value) {
		for (int i=0; i<count; i++) {
			if (storage[i] == value) {
				slideLeftFrom(i);
				// we need the next iteration of i to be the same
				i--;
			}
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder(count*4); // just an estimate of the size
		s.append("{");
		for (int i=0; i<count-1; i++) {
			s.append(storage[i]+",");
		}
		if (count>0) {
			s.append(storage[count-1]);
		}
		s.append("}");
		return s.toString();
	}

	/**
	 * The main method is a test harness that allows this programmer to
	 * do some tests to make sure the code is good enough for market.
	 * @param args Some command line arguments that are not used.
	 */

	public static void main(String[] args) {
		IntegerList list = new IntegerArrayList();
		list.insertFirst(3);
		list.insertFirst(10);
		list.insertFirst(1);
		list.insertLast(22);
		list.insertFirst(10);
		System.out.println("The list should be {10,1,10,3,22}");
		// should look like {10,1,10,3,22}
		System.out.println(list);
		list.remove(10);
		System.out.println("After removing 10:");
		System.out.println(list);
		System.out.println("The number of elements is "+list.size());
		list.removeAll();
		System.out.println("After removing all the elements:");
		System.out.println(list);
		System.out.println("The number of elements is now "+list.size());
	}
}
