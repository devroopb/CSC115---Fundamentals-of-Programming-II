/**
  INode is an integer singly linked node class. It stores an integer
  and an INode object which points to the next INode object.
  <p>
  adapted from your textbook, 3rd edition, p250
  @author  Janet J. Prichard
  @author  Frank M. Carrano
  @version %I%, %G%
  @since   1.0
*/
public class Node<T>
{
	public T item;
	public Node<T> next;
	/**
	 Default constructor. Sets the item to 0, next to null.
	*/
	public Node()
	{
		item=null;
		next=null;
	}
	/**
	 Constructor. Assigns the n to item, null to next.
	 @param n an integer assigned to instance variable item.
	*/
	public Node(T n)
	{
		item=n;
		next=null;
	}
	/**
	 Constructor. Assigns the n to item, nextNode to next.
	 @param n        an integer assigned to the instance variable item.
	 @param nextNode an INode object assigned to the instance object next
	*/
	public Node(T n,Node nextNode )
	{
		item=n;
		next=nextNode;
	}
}