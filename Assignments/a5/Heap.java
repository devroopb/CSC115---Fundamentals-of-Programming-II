/*
 * CSC115 Assignment 5
 * V00837868
 * 24/11/2K15
 * Heap.java
 * Heap is the hidden data type used as the main instance variable of the PriorityQueue.
 * Implementation of the PriorityQueue interface
 * @author Devroop Banerjee.
 */
import java.util.Arrays;

public class Heap{
	private ER_Patient[] heapArray;
	private final int INITIAL_SIZE = 2;
	private int count;

/*
 * Creates INITIAL_SIZE (2 in this case) empty heapArrays
 * Sets count to 0
 */

	public Heap(){
		heapArray = new ER_Patient[INITIAL_SIZE];
		count = 0;
	}

/*
 * Checks if the heapArray is empty
 * Return true is empty; false if not
 */

	public boolean isEmpty(){
		if(count == 0){
			return true;
		}else{
			return false;
		}	
	}

/*
 * Returns the number of items in the heap,
 * Not the size of the heap array.
 */
	public int size(){
		return count;
	}

/*
 * Inserts a patient into the heap array.
 * Uses ER_Patient patient as parameter
 */
	public void insert(ER_Patient patient){
		if(count == heapArray.length){
			growAndCopy();
		}

		if(count >= 0){
			heapArray[count] = patient;	
			count++;
			int c = count-1;
			ER_Patient temp;
			while(c > 0){
				int p = (c-1)/2;
				if(heapArray[c].prioritize(heapArray[p]) < 0){
					temp = heapArray[p];
					heapArray[p] = heapArray[c];
					heapArray[c] = temp;
					c = p;
				}else{
					break;
				}
			}
		}	
	}

/*
 * Removes the item at the root by copying the last item on the heap array 
 * Onto the root and trickling down accordingly
 * Throws an exception if the heap array is empty
 * Returns the root item
 */
	public ER_Patient removeRootItem(){
		if(isEmpty()){
			throw new NoSuchCategoryException("Nothing left to remove!");
		}

		ER_Patient toBeReturned = heapArray[0];
		int k = 0;
		int l = ((2*k)+1);

		heapArray[0] = heapArray[count-1];
		heapArray[count-1] = null;
		count--;
		while(l < count){
			int min = l;
			int r = l + 1;
			if(r < count){
				if(heapArray[r].prioritize(heapArray[l]) < 0){
					min++;
				}
			}
			if(heapArray[k].prioritize(heapArray[min]) > 0){
				ER_Patient temp = heapArray[k];
				heapArray[k] = heapArray[min];
				heapArray[min] = temp;
				k = min;
				l = 2*k+1;
			}else{
				break;
			}
		}
		return toBeReturned;
	}
/*
 * This traverses through the heap array and fixes the presentation of the contents at each index
 * Returns the fixed presentation of the contents
 */
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < heapArray.length; i++){
			s.append(heapArray[i]+"\n");
		}
		return s.toString();
	}
/*
 * This takes in the index as the parameter to fix the presentation of the contents at a specific index
 * Returns the fixed presentation of the contents
 */	
	
	public String toStringSpecific(int i){
		StringBuilder s = new StringBuilder();
		s.append(heapArray[i]+"\n");
		return s.toString();
	}

/*
 * Doubles the size of the heap array
 */

	private void growAndCopy(){
		ER_Patient[] newHeapArray = new ER_Patient[heapArray.length*2];
		for (int i = 0; i < count; i++) {
			newHeapArray[i] = heapArray[i];
		}
		heapArray = newHeapArray;
	}
	
/*
 * Main method contains the tester for this heap array
 * Has 4 tests which test each of the following methods:- isEmpty, insert, size, removeRootItem
 * Contains print statements for comprehension; catches NoSuchCategoryException
 */

	public static void main(String[] args){
		Heap heapPatients = new Heap();
		
		System.out.println("Checking the isEmpty method\n");
		if(heapPatients.isEmpty()==true){
			System.out.println("Passed Test 0.5!	(I checked if one aspect of isEmpty works; hence \"0.5\")\n");
		}else{
			System.out.println("Failed Test 0.5!\n");
		}
		
		heapPatients.insert(new ER_Patient("02:50:09",12,"Life-threatening"));
		heapPatients.insert(new ER_Patient("13:28:23",64,"Chronic"));
		heapPatients.insert(new ER_Patient("21:46:52",53,"Major fracture"));
		heapPatients.insert(new ER_Patient("09:25:16",51,"Life-threatening"));
		heapPatients.insert(new ER_Patient("18:38:27",19,"Major fracture"));
		heapPatients.insert(new ER_Patient("11:09:57",37,"Major fracture"));
		heapPatients.insert(new ER_Patient("19:41:25",56,"Walk-in"));
		heapPatients.insert(new ER_Patient("07:54:33",78,"Walk-in"));
		heapPatients.insert(new ER_Patient("22:55:48",31,"Chronic"));
		heapPatients.insert(new ER_Patient("23:59:59",28,"Walk-in"));
		heapPatients.insert(new ER_Patient("14:35:46",35,"Life-threatening"));
			
		System.out.println(heapPatients);
		
		if(heapPatients.isEmpty()==true){
			System.out.println("Failed Test 1!\n");
		}else{
			System.out.println("Passed Test 1!		(Tested that other aspect of isEmpty...)\n");
		}
		System.out.println("And while we're at the printed list of patients, let's check the size method\n.\n.\n.\nCurrently we have "+heapPatients.size()+" patients in the heap array\n");
		
		if(heapPatients.size() == 11){
			System.out.println("Passed Test 2!\n");
		}else{
			System.out.println("Failed Test 2!\n");
		}
		
		System.out.println("This test works by checking patients at indices 5 and 2 and comparing them with\nthe expected outcomes!\n\n\nExpected outcome for patient at index 5:	P53: 3 21:46:52 Major fracture\nPatient at index 5 after insertion:		"+heapPatients.toStringSpecific(5)+"\nExpected outcome for patient at index 2:	P37: 3 11:09:57 Major fracture\nPatient at index 2 after insertion:		"+heapPatients.toStringSpecific(2)+"\n");

		if(((heapPatients.toStringSpecific(5)).equals("P53: 3 21:46:52 Major fracture\n"))&&((heapPatients.toStringSpecific(2)).equals("P37: 3 11:09:57 Major fracture\n"))){
			System.out.println("Passed Test 3!\n");
		}else{
			System.out.println("Failed Test 3!\n");
		}
		
		System.out.println("I'm going to removeRootItem now! Get it? No? Okay...\n\nThis test will keep removing the root item till the heap array isEmpty (come\non, that was a good one!), and everytime it does so, the item removed will be\nprinted. I'm expecting the patients to be sorted out in ascending order with \nrespect to their priority ie:- the patient who came first with a life threatening condition will be treated first\n");
		
		try{
			for(int i = 0; i < 999999999; i++){
				System.out.println(heapPatients.removeRootItem());
			}
		}catch(NoSuchCategoryException e){

		}

		System.out.println("\nFinally, I'll print out the heap array and the number of patients and check if \nit's empty or not");
		System.out.print(heapPatients);
		System.out.println("Number of patients: " + heapPatients.size());
		if(heapPatients.isEmpty() == true && heapPatients.size() == 0){
			System.out.println("\nAs you can see, the heap array is empty and the number of patients is 0\n\nPassed Test 4!");
		}else{
			System.out.println("Failed Test 4!\n");
		}
	}	
}
