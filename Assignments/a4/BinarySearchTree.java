 /*
 * CSC115 Assignment 4
 * Devroop Banerjee
 * V00837868
 * 11/01/2K15
 * BinarySearchTree.java
 * Binary Search Tree carries out functions on a tree 
 * eg:- Create BST, traverse it, unit test it...
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree extends AbstractBinaryTree {

	private TreeNode root;

	/**
	 * Creates an empty BinarySearchTree.
	 */
	public BinarySearchTree(){
		root = null;
	}

	protected TreeNode getRoot(){
		return root;
	}

	protected void setRoot(TreeNode root){
		this.root = root;
	} 

	public boolean isEmpty(){
		if(root == null){
			System.out.println("Yup, it's empty!");
			return true;
		}else{
			System.out.println("Nope, not empty, yet...");
			return false;
		}

	}

	public void makeEmpty(){
		System.out.println("Emptying the tree now...");
		root = null;
	}

	public void insert(PatientMedRecord pm) {
		root = insertItem(root, pm);
	}

	/*
	 * Private recursive method that inserts an item into a subtree rooted
	 * at r.
	 * Returns the root of the subtree that has the new element.
 	 */
	private TreeNode insertItem(TreeNode r, PatientMedRecord pm){
		if(r == null){
			return new TreeNode(pm);
		}
		if(pm.compareTo(r.item) < 0){
			r.left = insertItem(r.left,pm);
			return r;
		}
		r.right = insertItem(r.right,pm);
		return r;
	}

	public PatientMedRecord retrieve(String id){
		return retrieveItem(root, id).item;

	}
	/*
	 * Private recursive method that looks for item from a subtree
	 * rooted at r.
	 * The key is the Patient id number
 	 * Returns the node containing the PatientMedRecord we are looking for, 
	 * without removing it from the tree.
 	 */
	private TreeNode retrieveItem(TreeNode r, String id){
		if(r == null){
			return null;
		}else if(r.item.getId().equals(id)){
			return r;
		}else if(r.item.getId().compareTo(id) > 0){
			return retrieveItem(r.left,id);
		}else{
			return retrieveItem(r.right,id);
		}
	}

	public void delete(String id){
		root = deleteItem(root, id);
	}

	/*
	 * Private recursive method that looks for the item and then 
	 * deletes that item from within the subtree rooted at r.
	 * Uses the deleteNode method and findLeftMost and deleteLeftMost method.
	 * Returns the node that is the root of the subtree that has changed.
	 */
	private TreeNode deleteItem(TreeNode r, String id){
		if(r == null){
			return null;
		}
		else{
			if(id.compareTo(r.item.getId()) == 0){
				return deleteNode(r);	
			}else if(id.compareTo(r.item.getId()) < 0){
				TreeNode nst = deleteItem(r.left, id);
				r.left = nst;
			}else{
				TreeNode nst = deleteItem(r.right, id);
				r.right = nst;
			}
		}	
		return r;
	}

	/*
	 * Private recursive method that either deletes the current node
	 * or overwrites the item in that node with one that is easier to delete.
	 * If r is the node to delete, then one of three cases applies:
	 * 1. If r has no children, return null.
	 * 2. If r has one child, then return that child.
	 * 3. If r has two children, then it cannot be detached.
	 * 	In this case, look for the left-most child of its right subtree and
	 *	substitute that particular item into this node, overwriting the previous
	 *	item.
	 *	Then delete the left-most child of r, which will either have one or two children
	 * If r is not the node to delete, recursively look for it in the appropriate
	 * subtree of r.
	 * Return the subtree either rooted at r or some other new root of this subtree.
	 */
	private TreeNode deleteNode(TreeNode r){
        if((r.right == null) && (r.left == null)){
            TreeNode temp = new TreeNode(r.item);
            return null;
        }else if((r.right != null) && (r.left == null)){
        	return r.right;
        }else if((r.left != null) && (r.right == null)){
        	return r.left;
        }else{
        	TreeNode temp = findLeftMost(r.right);
        	r.item = temp.item;
        	r.right = deleteLeftMost(r.right);
        	return r;
        }
	}

	/*
 	 * Helper method to recursively find and return the leftmost node of the subtree
	 * rooted at r.
	 */
	private TreeNode findLeftMost(TreeNode r){
		if (r == null){
			return null;
		}else if(r.left == null){
			return r;
		}else{
			return findLeftMost(r.left);
		}	
	}

	/*
	 * Helper method that recursively looks for, then deletes the left most node
	 * from the root of the subtree at r.
	 * Returns the subtree rooted at r or the new subtree if r is the one to remove.
	 */
	private TreeNode deleteLeftMost(TreeNode r){
		if(r.left == null){
			return r.right;
		}else{
			r.left= deleteLeftMost(r.left);
			return r;
		}
	}

	public Iterator<PatientMedRecord> preorderIterator(){
		return new BinaryTreeIterator(root,-1);
	}
	
	public Iterator<PatientMedRecord> inorderIterator(){
		return new BinaryTreeIterator(root,0);
	}

	public Iterator<PatientMedRecord> postorderIterator(){
		return new BinaryTreeIterator(root,1);
	}
	 
	/**
	 * Unit tester.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		AbstractBinaryTree tree = new BinarySearchTree();
		/*
		* inserts a node into the tree
		* checks insert method (with the help of isEmpty())
		*/
		System.out.println("\nCommencing Test Protocol in 3...2...1...\n\n\n");
		System.out.println("Testing the insert method...");

		tree.insert(new PatientMedRecord(7));
		tree.insert(new PatientMedRecord(5));
		tree.insert(new PatientMedRecord(9));
		tree.insert(new PatientMedRecord(2));
		tree.insert(new PatientMedRecord(6));
		tree.insert(new PatientMedRecord(8));
		tree.insert(new PatientMedRecord(10));
		tree.insert(new PatientMedRecord(1));
		tree.insert(new PatientMedRecord(3));
		tree.insert(new PatientMedRecord(4));
		if(tree.isEmpty() == false){
			System.out.println("Passed Test 1...\n\n\n");
		}else{
			System.out.println("Failed Test 1...\n\n\n");
		}
		


		/*
		* Prints out the preorder, inorder and postorder traversals of the nodes in the tree
		* checks the pre-,in-,and postorder iterators
		*/

		System.out.println("Testing Traversals now...");
		System.out.println("This test will compare each traversed item against a pre-built array with the expected results\n");
		Iterator<PatientMedRecord> preorderIterator = tree.preorderIterator();
      	System.out.println("Pre-Order Traversal:");
      	String [] nums = {"P07","P05","P02","P01","P03","P04","P06","P09","P08","P10"};
      	int i = 0;
      	while(preorderIterator.hasNext()){
        	Object element = preorderIterator.next();
        	System.out.print(" " + element);
        	PatientMedRecord num = (PatientMedRecord)element;
        	if(!nums[i].equals(num.getId())){
        		System.out.println("Failed Test 2...\n\n\n");
        	}
        	i++;
      	}
      	System.out.println();

      	Iterator<PatientMedRecord> inorderIterator = tree.inorderIterator();
      	System.out.println("In-Order Traversal:");
      	String [] nums2 = {"P01","P02","P03","P04","P05","P06","P07","P08","P09","P10"};
      	int j = 0;
      	while(inorderIterator.hasNext()){
        	Object element = inorderIterator.next();
        	System.out.print(" " + element);
        	PatientMedRecord num = (PatientMedRecord)element;
        	if(!nums2[j].equals(num.getId())){
        		System.out.println("Failed Test 2...\n\n\n");
        	}
        	j++;
      	}
      	System.out.println();

      	Iterator<PatientMedRecord> postorderIterator = tree.postorderIterator();
      	System.out.println("Post-Order Traversal:");
      	String [] nums3 = {"P01","P04","P03","P02","P06","P05","P08","P10","P09","P07"};
      	int k = 0;
      	while(postorderIterator.hasNext()){
        	Object element = postorderIterator.next();
        	System.out.print(" " + element);
        	PatientMedRecord num = (PatientMedRecord)element;
        	if(!nums3[k].equals(num.getId())){
        		System.out.println("Failed Test 2...\n\n\n");
        	}
        	k++;
      	}
      	System.out.println("\nPassed Test 2...\n\n\n");


      	System.out.println("Checking retrieve method now...");
      	System.out.println("(If P03 is retrieved, this test passes)");
      	if(tree.retrieve("P03").getId().equals("P03")){
      		System.out.println("Passed Test 3...\n\n\n");
      	}else{
      		System.out.println("Failed Test 3...\n\n\n");
      	}



      	System.out.println("Testing delete method...");
      	System.out.println("(Delete method tests deleteItem, deleteNode, findLeftMost, deleteLeftMost and obviously delete itself...");
      	System.out.println("That's 4 methods used in one, ergo, this has to pass 4 tests)");
      	System.out.println("This test deletes 3 different nodes satisfying the various conditions\n");
      	System.out.println("Deleting P01 (This is both a leaf and a left most child)");
      	System.out.println("Deleting P03 (This node has one child)");
      	System.out.println("Deleting P09 (This node has two children)\n");
      	tree.delete("P01");
      	tree.delete("P03");
      	tree.delete("P09");
      	System.out.println("Doing an In-Order Traversal of the tree after deletion to check delete method");
      	Iterator<PatientMedRecord> inorderIterator2 = tree.inorderIterator();
      	String [] nums4= {"P02","P04","P05","P06","P07","P08","P10"};
      	int h = 0;
      	System.out.println("Expected: P02 P04 P05 P06 P07 P08 P10");
      	System.out.print("Result: ");
      	while(inorderIterator2.hasNext()){
        	Object element = inorderIterator2.next();
        	System.out.print(" " + element);
        	PatientMedRecord num = (PatientMedRecord)element;
        	if(!nums4[h].equals(num.getId())){
        		System.out.println("\nFailed Tests 4, 5, 6 and 7...\n");
        	}
        	h++;
      	}
      	System.out.println("\nPassed Tests 4, 5, 6 and 7...\n\n\n");



		System.out.println("This test first checks if the tree is empty using the isEmpty method");
		System.out.println("Then, it  makes the tree empty using makeEmpty");
		System.out.println("Calls isEmpty again, to check if the tree is empty\n");
		tree.isEmpty();
		tree.makeEmpty();
		tree.isEmpty();
		System.out.println("Passed Tests 8 and 9...\n\n\n");
		System.out.println("Wow, I can't believe I finally fininshed it!!!\n\n\n");

		// DO MORE TESTING HERE
		// The following will draw the current tree.
		// Once you have a single element inserted, just uncomment the
		// code below. 
		// If the tree is empty, a NullPointerException is thrown
		//DrawableBTree dbt = new DrawableBTree(tree);
		//dbt.showFrame();
	}
}

