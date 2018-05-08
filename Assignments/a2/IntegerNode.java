/**
 * CSC115 Assignment 2 : Containers
 * IntegerNode.java
 * Created for use by CSC115 Fall 2015
 */ 

/**
 * The IntegerNode class is the single component of the LinkedIntegerList.
 * See Textbook, page 249 for a description of the Integer Node.
 * In this version, we leave out the packaage statement and assume that
 * the package is the current directory we are working in.
 */

class IntegerNode {
	int item;
	IntegerNode prev;
	IntegerNode next;

	/**
	 * Creates a Node that contains an integer.
 	 * @param item The integer contained in the node.
	 * @param prev The node that comes before this one in the list.
	 * @param next The node that comes after this one in the list.
	 */
	public IntegerNode(int item, IntegerNode prev, IntegerNode next) {
		this.item = item;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * Creates a Node that contains an integer that is not attached to the list.
	 * @param item The integer contained in the node.
	 */
	public IntegerNode(int item) {
		this(item,null,null);
	}
}


