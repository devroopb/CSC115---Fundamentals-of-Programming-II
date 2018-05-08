/*
 * Assignment 1 : The Baseball team.
 * Player.java
 * @author Devroop Banerjee.
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

/*
 * A Player is a baseball player who has a name and a batting average.
 */
public class Player {
	private String name;
	private int battingAvg;

	/**
	 * Initialize this instance of Player,
	 * setting the batting average to 0.
	 * @param name The name of the player.
	 */
	public Player(String name){
		this.name = name;
		battingAvg = 0;
	}

	/**
	 * Initialize this instance of Player.
	 * @param name The name of the player.
	 * @param battingAvg The batting average of this player.
	 */
	public Player(String name, int battingAvg){
		this.name = name;
		this.battingAvg = battingAvg;
	}

	/**
	 * Change the name associated with this Player.
	 * @param newName The new name.
	 */
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * @return the name associated with this Player.
	 */
	public String getName(){
		return name;
	}

	/**
	 * Change the batting average associated with this Player.
	 * @param newBattingAvg The new batting average.
	 */
	public void setBattingAvg(int newBattingAvg){
		battingAvg = newBattingAvg;
	}

	/**
	 * @return the batting average associated with this Player.
	 */
	public int getBattingAvg() {
		return battingAvg;
	}

	/**
	 * Compares this instance of Player to another.
	 * Two players are equal if they have same name.
	 * They may have different batting averages and be equal.
	 * @param other The 'other' Player.
	 * @return True if the players have the same name
	 * 	False if they do not have the same name.
	 */
	public boolean equals(Player other){
		if (name.equals(other.getName())){
			return true;
		}else{ 
			return false;
		}	
	}

	/**
	 * Provides a string representation of this player.
	 * For example, the following code:
	 * <code>
	 * Player p = new Player("Derek Jeter", 265);
	 * p.toString();
	 * </code>
	 * will return the value:
	 * <code>
	 * Derek Jeter:265
	 * </code>
	 * @return The string as described.
	 */
	public String toString(){
		return name + ":" + battingAvg;

	}
}
