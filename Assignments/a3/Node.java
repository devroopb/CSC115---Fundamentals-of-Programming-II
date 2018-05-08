/*
* CSC115 Assignment 3
* V00837868
* 10/12/2K15
* Node.java
* Node is an integer singly linked node class. It stores an integer and an Node object which points to the next Node object <n>.
* @author Devroop Banerjee.
*/

public class Node<E>{
	public E item;
	public Node<E> next;
	public Node<E> prev;

/*
Default constructor. Sets the item to null, next to null.
*/

	public Node(){
		item = null;
		next = null;
		prev = null;
	}

/*
Constructor. Assigns the n to item, null to next.
@param n an integer assigned to instance variable item.
*/

	public Node(E n){
		item = n;
		next = null;
		prev = null;
	}

/*
Constructor. Assigns the n to item, nextNode to next.
@param n an integer assigned to the instance variable 
item. @param nextNode an INode object assigned to the 
instance object next.
*/	

	public Node(E n,Node nextNode, Node prevNode){
		item = n;
		next = nextNode;
		prev = prevNode;
	}
}