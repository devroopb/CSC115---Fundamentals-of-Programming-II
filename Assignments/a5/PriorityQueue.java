/*
 * The PriorityQueue is a Queue of ER_Patients, where
 * the patient in the queue with the highest
 * priority is always the next item to be removed.
 */
 
//System.out.println("");
public class PriorityQueue {
	private Heap heap;
	int count;

/*
 * Creates an empty priority queue.
 */
	public PriorityQueue() {
		heap = new Heap();
		count = 0;
	}
	
/*
 * Adds a patient to the queue with an associated priority
 */
	public void enqueue(ER_Patient patient){
			heap.insert(patient);
	}

/*
 * Removes patients from the queue with the highest priority
 * Returns the patient
 */
	public ER_Patient dequeue() {
		return heap.removeRootItem();
	}

/*
 * Checks if the queue is empty
 * If it is, returns true; else returns false
 */
	public boolean isEmpty(){
		if(count == 0){
			return true;
		}else{
			return false;
		}	
	}
	
/*
 * The main method contains the tester for this implementation of PriorityQueue
 */
	public static void main(String[] args){
		Heap heap = new Heap();
		
		System.out.println("Checking the isEmpty method\n");
		if(heap.isEmpty()==true){
			System.out.println("Passed Test 0.5!	(I checked if one aspect of isEmpty works; hence \"0.5\")\n");
		}else{
			System.out.println("Failed Test 0.5!\n");
		}

		heap.insert(new ER_Patient("13:50:09",12,"Life-threatening"));
		heap.insert(new ER_Patient("22:28:23",64,"Chronic"));
		heap.insert(new ER_Patient("20:46:52",53,"Major fracture"));
		heap.insert(new ER_Patient("19:25:16",51,"Life-threatening"));
		heap.insert(new ER_Patient("14:38:27",19,"Major fracture"));
		heap.insert(new ER_Patient("18:09:57",37,"Major fracture"));
		heap.insert(new ER_Patient("21:41:25",56,"Walk-in"));
		heap.insert(new ER_Patient("23:54:33",78,"Walk-in"));
		heap.insert(new ER_Patient("16:55:48",31,"Chronic"));
		heap.insert(new ER_Patient("15:59:59",28,"Walk-in"));
		heap.insert(new ER_Patient("17:35:46",35,"Life-threatening"));

		System.out.println(heap);

		if(heap.isEmpty()==true){
			System.out.println("Failed Test 1!\n");
		}else{
			System.out.println("Passed Test 1!		(Tested that other aspect of isEmpty...)\n");
		}

		System.out.println("And while we're at the printed list of patients, let's check the size method\n.\n.\n.\nCurrently we have "+heap.size()+" patients in the queue\n");
		
		if(heap.size() == 11){
			System.out.println("Passed Test 2!\n");
		}else{
			System.out.println("Failed Test 2!\n");
		}
		
		System.out.println("This test works by checking patients at indices 5 and 2 and comparing them with\nthe expected outcomes!\n\n\nExpected outcome for patient at index 5:	P53: 3 20:46:52 Major fracture\nPatient at index 5 after insertion:		"+heap.toStringSpecific(5)+"\nExpected outcome for patient at index 2:	P37: 3 18:09:57 Major fracture\nPatient at index 2 after insertion:		"+heap.toStringSpecific(2)+"\n");

		if(((heap.toStringSpecific(5)).equals("P53: 3 20:46:52 Major fracture\n"))&&((heap.toStringSpecific(2)).equals("P37: 3 18:09:57 Major fracture\n"))){
			System.out.println("Passed Test 3!\n");
		}else{
			System.out.println("Failed Test 3!\n");
		}
		
		System.out.println("I'm going to removeRootItem now! Get it? No? Okay...\n\nThis test will keep removing the root item till the heap array isEmpty (come\non, that was a good one!), and everytime it does so, the item removed will be\nprinted. I'm expecting the patients to be sorted out in ascending order with \nrespect to their priority ie:- the patient who came first with a life threatening condition will be treated first\n");
		
		try{
			for(int i = 0; i < 999999999; i++){
				System.out.println(heap.removeRootItem());
			}
		}catch(NoSuchCategoryException e){

		}


		System.out.println("\nFinally, I'll print out the heap array and the number of patients and check if \nit's empty or not");
		System.out.print(heap);
		System.out.println("Number of patients: " + heap.size());
		if(heap.isEmpty() == true && heap.size() == 0){
			System.out.println("\nAs you can see, the heap array is empty and the number of patients is 0\n\nPassed Test 4!");
		}else{
			System.out.println("Failed Test 4!\n");
		}

	}
			
}
	
