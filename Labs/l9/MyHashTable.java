/**
  A hash table stores student information.
*/
public class MyHashTable
{
	private final int HASH_TABLE_SIZE=7; //a prime number
	private MyLinkedList[] table; //hash table 
	private int count; //number of student objects
	
	/**
	  Create HASH_TABLE_SIZE empty MyLinkedList objects. In this case, create 7 empty lists. Set count to 0.
	*/
	public MyHashTable()
	{
		table = new MyLinkedList[HASH_TABLE_SIZE];
		for(int i = 0; i<table.length; i++)
		{
			table[i] = new MyLinkedList();
		}
		count = 0;
	}
	
	/**
	  return true if the table is empty, false otherwise.
	*/
	public boolean isEmpty() //refer to count
	{
		if(count == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/**
	  insert a student "obj" into the hash table. Need to find the index of the table based on the student number. Then insert the student "obj" into the list at that index.
	*/
	public void insert(Student obj)
	{
		int g = hashIndex(obj.getStudentNum()); //hash the students number to find its index
		table[g].insert(obj); 
		
		count++;
	}
	
	/**
	  Based on the student number (or ID), remove the student if found and return true, return false if not found. Throw an exception if the list is empty.
	*/
	public boolean remove(String studentID)throws EmptyListException
	{
		int g = hashIndex(studentID); //hash the ID to find the students index.
		
		if (table[g].remove(studentID) == true)
		{
			count --;
			return table[g].remove(studentID);
		}
		
		else
		{
		return table[g].remove(studentID);
		}
		
	}
	
	/**
	  Based on the student number (or ID), return the student object if found, return null if not found. Throw an exception if the list is empty.
	*/
	public Student search(String studentID)throws EmptyListException
	{
		int g = hashIndex(studentID);
		
		return table[g].search(studentID);
		
	}
	
	/**
	  Based on the student number (or ID), calculate the array (table) index. Throw a HashException object if the studentID is null or empty. Return the array index.
	*/
	public int hashIndex(String studentID)throws HashException
	{
		
		int num = 0;
		
		for(int i = 0; i<studentID.length(); i++)
		{
			num += studentID.charAt(i);
			num = num%7;
		}
		
		return num;
	}
	
	/**
	  A string representation of the hash table. One student per line.
	*/
	public String toString()
	{
		String output="";
		for(int i=0; i<table.length; i++)
		{
			if(table[i].size()!=0)
				output += table[i].toString()+"\n"; 
		}
		return output;
	}
	
	/**
	  return the number of student object in the table.
	*/
	public int size()
	{
		return 0;
	}
	public static void main(String[] args)
	{
		
	}
}