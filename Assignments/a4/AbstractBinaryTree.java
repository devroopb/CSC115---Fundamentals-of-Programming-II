import java.util.Iterator;

/**
 * CSC115 201509 Assignment 4 handout.
 *
 * This abstract class sets necessary methods for a BinarySearchTree 
 * used in a CSC115 assignment.
 * The items internal to the nodes of the tree are PatientMedRecord objects.
 * The key value is the patientId field.
 * It is a simplified modification of the BinarySearchTree class described
 * in the texbook on page 616.
 */

public abstract class AbstractBinaryTree {

	/**
 	 * @return true if there are no items in the tree, false otherwise.
	 */
	public abstract boolean isEmpty();

	/**
	 * This method is accessible only to a subclass or class inside
	 * the same directory as this one.
	 * @return The root of the tree.
	 */
	protected abstract TreeNode getRoot();

	/**
	 * This method is accessible only to a subclass or class inside
	 * the same directory as this one.
	 * @param root The new root of the tree.
	 */
	protected abstract void setRoot(TreeNode root);

	/**
	 * Empties the tree of all items.
	 */
	public abstract void makeEmpty();

	/**
 	 * Inserts a patient record into the tree, maintaining the required order
	 * of the tree.
	 * NOTE: It is assumed that a patient will not be inserted if it is already in the tree.
	 * @param p The patient record to insert. The key that is used to maintain the BST order
	 * 	is p.patientId
	 */
	public abstract void insert(PatientMedRecord p);

	/**
	 * Retrieves a patient record from the tree without removing it.
	 * If the patient record is not there, then null is returned.
	 * @param id the key value of the patient record to retrieve.
	 * @return The PatientMedRecord associated with the patient id.
 	 */
	public abstract PatientMedRecord retrieve(String id);

	/**
	 * Removes the patient record from the tree.
	 * If the patient record is not there then nothing is deleted.
	 * @param id The key value of the patient record to delete.
	 */
	public abstract void delete(String id);

	/**
 	 * @return a pre-order iterator object for this tree.
	 */
	public abstract Iterator<PatientMedRecord> preorderIterator();

	/**
	 * @return an in-order iterator object for this tree.
	 */
	public abstract Iterator<PatientMedRecord> inorderIterator();

	/**
	 * @return a post-order iterator object for this tree.
	 */
	public abstract Iterator<PatientMedRecord> postorderIterator();
}
