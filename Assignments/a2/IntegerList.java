/**
 * CSC115 Assignment 2 : Containers.
 * IntegerList.java
 * Created for use by CSC115 Fall2015
 */

/*
 * NOTE TO PROGRAMMER:
 * Do not alter this file!
 */

/**
 * A completed interface for a list container.
 * This ADT specification is similar, but not identical to the List ADT
 * described in the textbook.
 */
public interface IntegerList {

	/**
	 * Inserts an integer to the front of the list.
	 * For example, if <code>list</code> is a list of integers {1,2,3}, then
	 * <code>list.addFront(9)</code> will alter the list to contain {9,1,2,3} in 
	 * that order.
	 * @param k The integer to add to the front of the list.
	 */ 
	public void insertFirst(int k);	

	/**
	 * Inserts an integer to the back of the list.
	 * For example, if <code>list</code> is a list of integers {1,2,3}, then
	 * <code>list.addBack(9)</code> will alter the list to contain {1,2,3,9} in
	 * that order.
	 * @param k The integer to add to the back of the list.
	 */
	public void insertLast(int k);

	/**
	 * @return The number of elements in the list.
	 */
	public int size();

	/**
 	 * Each integer in the list has a position between 0 and <code>size()</code>-1.
 	 * @param pos The valid position (or index) number of an integer in the list.
	 * 	Note that if the position is not valid, there is no error checking and the results
	 * 	 are unpredictable.
	 * @return The integer in the list whose position is indicated by <code>pos</code>.
	 */
	public int get(int pos);

	/**
 	 * Removes all the integers from the list, resulting in an empty list.
	 */
	public void removeAll();

	/**
	 * Removes all instances of the given integer from the list.
	 * For example, if the list is {67,12,13,12}, then <code>remove(12)</code>
	 * will alter the list to {67,13}.
	 * @param value The integer value, whose every occurrence will be removed.
	 * 	Note that if the value is not in the list, then nothing is removed.
 	 */
	public void remove(int value);

	/**
 	 * A printout of the list is in the form:
	 * <code>{1,2,3,4}</code>
	 * or <code>{}</code> for an empty list.
	 * @return The string representation of the list, formatted as above.
	 */

	public String toString();
}
