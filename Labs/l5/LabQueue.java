/**
 * Queue.java
 *
 * A specification of the Queue ADT
 *
 */
public class LabQueue<T> implements Queue<T>
{
	private Node<T> head, tail;

	public LabQueue()
	{
		head = null;
		tail = null;
	}
	
	//return true if the queue is empty, false otherwise
	public boolean isEmpty()
	{
		if(head == null){
			return true;
		}else{
			return false;
		}
		
	}
	
	//add element to the end of the queue
	public void enqueue (T element)
	{
		Node<T> newNode = new Node<T>(element);
		if(head == null){
			head = newNode;
		}else{
			Node<T> k = head;
			while(k.next != null){
				k = k.next;
			}
			k.next = newNode;
		}
	}
	
	//remove the head element of the queue, throws QueueEmptyException if the queue is empty
	public T dequeue() throws QueueEmptyException
	{
		if(head == null){
			throw new QueueEmptyException();
		}else{
			Node<T> temp = head;
			head = head.next;
			head.next = head.next.next;
			return temp.item;
		}
		
	}
	
	//retrieve, not remove the head element of the queue, throws QueueEmptyException if the queue is empty
	public T peek() throws QueueEmptyException
	{
		if(head == null){
			throw new QueueEmptyException();
		}else{
			return head.item;
		}	
	}
	
	//make the queue empty
	public void dequeueAll()
	{
		head = null;
	}
	
	public String toString()
	{
		String output = "{";
		Node<T> current = head;
		while(current != null){
			output += current.item;
				if(current.next != null){
					output += ",";
				}
			current = current.next;
		}
		return output + "}";
	}

	public static void main(String[] args)
	{		
		LabQueue <String> lq = new LabQueue();
		try{
			lq.dequeue();
			lq.peek();
		}catch(QueueEmptyException e)
		{
		}
	}
}