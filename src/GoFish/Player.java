package GoFish;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @Author Rafae K
 */
public abstract class Player {

    private String name; //the unique name for this player
    private GroupOfCards hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Draw a card from the deck
     * @param deck GroupOfCards deck from GoFishGame
     */
    public void drawCard(GroupOfCards deck) {
        //Take card from GoFishGame Deck
        //hand.add(deck.index(random from 1 - remaining cards));
    }

    /**
     * Ask another player for a card
     * @param playerToAsk Which player you want to ask for a card
     * @param cardToLookFor What card you are asking for
     */
    public void askForCard(Player playerToAsk, StandardCard cardToLookFor) {
        //Only can ask for hard player has a suit off
        //check playerToAsk hand for cardToLookFor
        //takeCard();
    }

    /**
     * Take card from player
     * @param player
     * @param cardToRemove
     */
    public void takeCard(Player player, StandardCard cardToRemove) {
        //if hand contains card
        //hand.remove(card.equals(cardToRemove))
    }

    /**
     * Display hand
     */
    public void displayHand() {
        //While i=0; i < hand.getCards().size; i ++
        //hand.getCards().indexOf(i)
    }

    /**
     * End turn
     * @return true
     */
    public boolean endTurn() {
        return true;
    }


}
