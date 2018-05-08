/*
 * CSC115 Assignment 1 : The Baseball team.
 * PlayerList.java
 * author : Devroop Banerjee.
 */

/*
 * NOTE TO PROGRAMMER:
 * Implement each method as per its description.
 * Do not change the javadoc commenting or
 * the method header.
 * You may remove this comment block when you are finished.
 *
 * NOTE that some methods have a return statement.
 * These are to ensure that the shell will compile successfully.
 * They will need to be replaced with working code.
 * 
 * BEFORE CHANGING ANYTHING:
 * Put all the java files into a single directory and type:
 * 	javac *.java
 * Even though nothing works yet, everything compiles.
 * Successful compilation produces no output, but a set of *.class
 * files were created.
 *
 * Next, check out the professional web documentation that
 * is created (by extracting the javadoc comments above each method).
 * Type:
 *	javadoc *.java
 * Then open (double-click) the file called index.html.
 */

/**
 * PlayerList is a sequential list of Players.
 * The list can be of any size.
 */
public class PlayerList {
	private static final int INITIAL_SIZE = 2;

	private Player[] storage;
	private int count;


	/**
 	 * Create an empty PlayerList.
	 */
	public PlayerList(){
		this.storage = new Player[INITIAL_SIZE];
		this.count = 0;
		// Initialize the storage array and set count to 0.
	}

	/**
	 * Retrieves the player at the given index starting at 0.
	 * Pre-Condition: The index must be between 0 and size()-1.
	 * @param index The position in the list, which must be in {0, size-1).
	 * @return The given Player if the index is inside the list bounds.
	 */
	public Player get(int index) {
		if(index >= 0 || index < storage.length){
			return storage[index];
		}else{
			System.out.println("I'm sorry, the index you entered is out of bounds");
		return null;
		}
	}

	/**
	 * Removes the Player at position index.
	 * Pre-Condition: The index is between 0 and size()-1, inclusive.
	 * If index is out of bounds, nothing is removed.
	 * @param index The position in the list, 
	 *		where index 0 is the first Player.
	 */
	public void remove(int index){
		Player[] newstorage = new Player[storage.length];

		if(index >= 0 && index <= storage.length){
			for(int c = 0; c < index ; c++){
  			newstorage[c] = storage[c];
  			}
     	
     		for(int c = index + 1; c < storage.length; c++){
     			newstorage[c-1] = storage[c];
			}
		}else if(index < 0 || index > storage.length){
			System.out.println("I'm sorry, the index you entered is out of bounds");
   		}
	
		storage = newstorage;
		count--;
	}

	/**
	 * @return The number of elements in the list.
	 */
	public int size(){
		return count;		
	}	
	/**
	 * Adds a player to the list.
	 * Does not check for duplicates.
	 * @param p The new player.
	 */
	public void add(Player p) {
		if(storage.length == count){
			Player [] temp = new Player[(storage.length)*2];
			for(int c = 0; c < storage.length; c++){
				temp[c] = storage[c];
			}
			storage = temp;

		}
		storage[count] = p;
		count++;
		/*
		 * NOTE TO PROGRAMMER:
		 * The array you allocated to store Players might
		 * get full, but you are still required to add this
 		 * Player (until the JVM runs out of memeory!)
		 *
		 * This means that you should check to see if the array
		 * is currently full. If it is, allocate a new array
		 * that is twice as big, then copy the values over
		 * and updaet the storage reference to be the new array.
		 * Finally, add the new Player.
		 */
	}

	/**
	 * Finds the Player in the list.
	 * @param p The player that we are looking for.
 	 * @return The index number of the player
	 * 		or -1 if the player is not in the list.
	 */
	public int find(Player p){
		for(int c = 0; c < storage.length; c++){
			if(storage[c] != null && storage[c].equals(p)){
				return c;
			}
		}
		return -1;
	}	
}
