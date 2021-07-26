package GoFish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 *
 * @author dancye
 * @author Rafae K
 *
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<StandardCard> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<StandardCard> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Used to search for card
     * @param card Card being searched for
     * @return Card was found or not
     */
    public boolean searchCards(StandardCard card) {

        //If cards contains card return true else return false
        return true; //Placeholder
    }

}
