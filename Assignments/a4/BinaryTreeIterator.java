import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * CSC115 Assignment 4
 * Devroop Banerjee
 * V00837868
 * 11/01/2K15
 * BinaryTreeIterator.java
 * The BinaryTreeIterator is an iterator specifically for a reference-based
 * binary tree.
 * It has access to the BinaryTree's TreeNode class to traverse the tree.
 * In this version, we stuff all the elements of the tree into a java LinkedList
 * and then use the list's iterator.
 * See the documentation for java.util.LinkedList which extends AbstractSequentialList,
 * and that class has an iterator() method that returns a sequential Iterator.
 */

public class BinaryTreeIterator implements Iterator<PatientMedRecord>{

	private TreeNode root;
	private PatientMedRecord currentItem;
	private LinkedList<PatientMedRecord> list;
	private Iterator<PatientMedRecord> iterator;

	/**
	 * Creates a new BinaryTreeIterator object for a tree.
	 * Note that this constructor is not public because it should only
	 * be created within a method of the specific BinaryTree that uses it.
	 * @param root The root of the tree.
	 * @param order The order of the traversal that determines the order of the items.
	 *			-1 : preorder.
	 *			 0 : inorder.
	 *			 1 : postorder.
	 */
	BinaryTreeIterator(TreeNode root, int order){
		this.root = root;
		currentItem = null;
		list = new LinkedList<PatientMedRecord>();
		switch(order){
			case -1: 
				setPreorder();
				break;
			case 0:
				setInorder();
				break;
			case 1:
				setPostorder();
				break;
		}
		iterator = list.iterator();
	}

	/**
	 * @return True if there are more PatientMedRecords to be accessed.
	 */
	public boolean hasNext(){
		return iterator.hasNext();
	}

	/**
	 * @return The next PatientMedRecord to be accessed.
	 * @throws NoSuchElementException if there is no next PatientMedRecord.
	 */
	public PatientMedRecord next() throws NoSuchElementException{
		return iterator.next();
	}

	/**
	 * The following method should NEVER be implemented.  Who knows what the Java developers were thinking
	 * when they put this one into the Iterator interface!!
	 */
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	// This one is completed as an example for the next two...
	private void setPreorder(){
		preorder(root);
	}

	private void setInorder(){
		inorder(root);
	}

	private void setPostorder(){
		postorder(root);
	}

	// In each of these recursive methods, you are inserting the elements of the tree into the list.
	// The first one is done for you.
	private void preorder(TreeNode node){
		if (node == null) 
		return;
		
		list.add(node.item);
		preorder(node.left);
		preorder(node.right);
	}

	private void inorder(TreeNode node){
		if (node == null)
		return;
		
		inorder(node.left);
		list.add(node.item);
		inorder(node.right);
	}

	private void postorder(TreeNode node){
		if (node == null) 
		return;
		
		postorder(node.left);
		postorder(node.right);
		list.add(node.item);
	}

// NOTE that there is no unit teseter (main method) here.  All testing
// of the tree iterator class can be done in the BinarySearchTree main method.
}
		

