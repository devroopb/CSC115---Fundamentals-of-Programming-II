/**
 * Stack.java
 * A specification of the Stack ADT
 * Created for CSC115 assignment 3.
 * Note that this interface uses generics
 * so the stack can use complex data type for its elements
 */
public interface Stack<E>
{
	/**
	 * @return true if the stack is empty, false if it is not.
	 */
	public boolean isEmpty();
	/**
	 * Places an element at the top of the stack.
	 * @param element The element to be added.
	 */
	public void push (E element);
	/**
	 * Remove the top elememt from the stack.
	 * @return The element that was removed.
	 */
	public E pop() throws StackEmptyException;
	/**
 	 * Looks at the top elememt of the stack without removing it.
	 * @return The top element.
	 */
	public E peek() throws StackEmptyException;
	/**
	 * Remove all elements from the stack.
	 */
	public void popAll();
}

