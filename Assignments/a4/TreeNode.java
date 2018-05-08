/**
 * CSC115 201509 Assignment 4 handout.
 *
 * A TreeNode for this assignment is used in a BinarySearchTree that
 * contains PatientMedRecord items.
 * The textbook uses instance variables called leftChild and rightChild,
 * but in order to relate well to the graphical rendering, we use
 * the names left and right with no loss of meaning.
 */

class TreeNode {
	PatientMedRecord item;
	TreeNode left;
	TreeNode right;

	/**
	 * Creates a TreeNode.
	 * @param item The item contained in this node.
	 * @param left The left child of this node.
	 * @param right The right child of this node.
	 */
	public TreeNode(PatientMedRecord item, TreeNode left, TreeNode right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	/**
 	 * Creates a TreeNode that has no children nodes.
	 * @param item The item contained in this node.
	 */
	public TreeNode(PatientMedRecord item) {
		this(item,null,null);
	}
}
