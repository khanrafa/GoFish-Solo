package GoFish;

/**
 * Class that models an NPC
 *
 * @Author Rafae K
 */

public class NPC extends Player {

	private String name;

	/**
	 * A constructor that allows you to set the player's unique ID
	 *
	 * @param name the unique ID to assign to this player.
	 */
	public NPC(String name) {
		super(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * simulate hand and print out moves
	 */
	public void play() { //Sim Hand
		//Simulate valid moves
		//print out moves 1 at a time
	}

}
