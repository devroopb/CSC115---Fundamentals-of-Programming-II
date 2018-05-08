/**
 * CSC115 Assignment 2 : Containers.\
 * V00837868
 * 10/01/2-15
 * IntegerLinkedList.java
 * This assignment introduces the idea of containers,
 * which is a data structure used to store a collection
 * of items. This programstores only integers.
 * @author Devroop Banerjee.
 */

/*
 * NOTE TO PROGRAMMER:
 * Complete the implementation of all the methods as specified.
 *
 * Start by creating "stub" methods that are required by the 
 * IntegerList interface.
 * Return null or simple values where the methods have return values.
 * Then compile, correcting any syntax errors and repeat.
 * 
 */

/**
 * IntegerLinkedList is a sequential list of integers, that uses
 * a linked data structure in its implementation.
 */
public class IntegerLinkedList implements IntegerList {

	private IntegerNode head;
	private IntegerNode tail;
	private int count;

// PROGRAMMER TO PLACE HEADER COMMENT HERE
	public IntegerLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * IntegerList Interface methods..
	 * NOTE THAT THESE do not need header comments. They use the
	 * comments from the IntegerList interface.
	 */


	public void insertFirst (int k){
		if(head == null){
            head = new IntegerNode(k);
            tail = head;
        }else{
        	IntegerNode temp = head;
        	IntegerNode newNode = new IntegerNode(k);
        	head = newNode;
        	head.next = temp;
        	temp.prev = newNode;
        }
        count++;
	}

	
	public void insertLast(int k){
		if(tail == null){
            tail = new IntegerNode(k);
            head = tail;
        }else{
        	IntegerNode newNode = new IntegerNode(k);
        	tail.next = newNode;
        	newNode.prev = tail;
        	tail = newNode;
        }
        count++;
	}

	public int size(){
		return count;
	}

	public int  get (int pos){
		if(head == null){
			return -1;
		}

		IntegerNode temp = head;
			for(int i = 1; i <= pos; i++){
				temp = temp.next;
				
			}
		return temp.item;

	}

	public void removeAll(){
		head = null;
		tail = null;
		count = 0;
	}

	public void remove(int value){
		IntegerNode prev = null;
		IntegerNode temp = head;

		while (temp !=null){
			if(head.item == value){
				head = head.next;
				temp = temp.next;
				count--;
			}else{
				if(temp.item == value){
					temp = temp.next;
					prev.next = temp;
					count--;
				}else{
					prev = temp;
					temp = temp.next;
				}
			}
		}
	}

	public String toString(){
		String output = "{";
		IntegerNode current = head;
		while(current != null){
			output += current.item;
				if(current.next != null){
					output += ",";
				}
			current = current.next;
		}
		return output + "}";
	}
}
