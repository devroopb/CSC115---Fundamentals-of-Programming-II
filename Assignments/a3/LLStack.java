 /*
* CSC115 Assignment 3
* V00837868
* 10/12/2K15
* LLStack.java
* LLStack is a class that implements the Stack interface using a linked list structure to contain its elements.
* @author Devroop Banerjee.
*/

public class LLStack<E> implements Stack<E>{
	private Node<E> head;
	private Node<E> tail;

/*
default constructor	
*/
	public LLStack(){
		head = null;
		tail = null;
	}

/*
checks if the stack is empty.
@return true if the stack is empty.	
*/

	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}

/*puts element on the top of the stack.
@param element The element to be added.	
*/

	public void push (E element){

		Node<E> newNode = new Node<E>(element);
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
        	 newNode.next = head;
        	 head= newNode;
		}

	}

/*removes the top most element from the stack.
@return The element that was removed.
*/

	public E pop() throws StackEmptyException{
		if(head == null){
			throw new StackEmptyException("this is an empty stack");
		}else{
			Node<E> temp = head;
			head = head.next;
			return temp.item;
		}
	}

/*checks the top most element without removing it.
@return The top element.	
*/

	public E peek() throws StackEmptyException{
		if(head == null){
			throw new StackEmptyException();
		}else{
			return head.item;
		}
	}

/*
empties the stack	
*/

	public void popAll(){
		head = null;
		tail = null;
	}

	public static void main(String[] args){		
		LLStack <Integer> LLs = new LLStack();
			try{
				LLs.pop();
				LLs.peek();
			}catch(StackEmptyException e){
		}
	}
}