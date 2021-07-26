package GoFish;

import java.util.ArrayList;

/**
 * Starts a game of go fish.
 *
 * @author Rafae K
 */

public class GoFishGame extends Game{

    //Standard 52 card deck
    private GroupOfCards deck = new GroupOfCards(52);
    int currentTurn = 0; //Keeps track of turn

    public GoFishGame() {
        super("GoFish");
    }

    /**
     * Starts game
     */
    @Override
    public void play() { //Start game
        getPlayersInfo.getPlayersInfo();
        nextTurn();
    }

    /**
     * Moves to next turn
     */
    @Override
    public void nextTurn() {
        currentTurn++;
        //Use % to determine turn and call Player
        //checkIfNPC();
    }

    /**
     * Check if there is pairs in play and if not
     * checks who has the most and declares them winner
     */
    @Override
    public void declareWinner() {
        //Check pairs and deck state
    }

    /**
     * Checks if player is an NPC
     * @param player
     * @return
     */
    public boolean checkIfNpc(Player player) {
        if (player instanceof Human) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks pairs (Check deck or player hands?)
     */
    public void checkPairs(){
        //getPlayers() loop trough hands and check for pairs
        //or
        //Check for pairs left in deck
    }

    /**
     * Distributes initial hands
     * @param players
     */
    public void dealCards(ArrayList<Player> players) {
        // 7 cards 2-4 players
        // 5 cards 5-6 players
    }
}
