package GoFish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <GoFishCard> cards = new ArrayList();
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<GoFishCard> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * This method is to set the list of the hand card and
     * the deck
     * @param cards: total cards
     */
    public void setCards(ArrayList<GoFishCard> cards) {
        this.cards = cards;
    }
    
    /**
     * This method is to add card from deck
     * @param c: the card that is whether added or removed
     */
    public void addCard(GoFishCard c) {
        cards.add(c);
    }
    
    /**
     * This method is to get card's position number 
     * in ArrayList
     * @param index: the card's position number
     * @return the card's position number
     */
    public GoFishCard getCard(int index) {
        return cards.get(index);
    }
    
    /**
     * This method is to remove the target card
     * in ArrayList 
     * @param index: the card's position number
     * @return the card's position number
     */
    public GoFishCard removeCard(int index) {
        return cards.remove(index);
    }
    
    /**
     * This method is to remove the card that will 
     * be removed from hand 
     * @param c: card that is removed
     * @return true for card removed
     */
    public boolean removeCard(GoFishCard c) {
        return cards.remove(c);
    }
    
 
    /**
     * Display hard after each players turn 
     */
    public void displayCards() {
        for (int i = 0;i < getSize();i++) {
            System.out.println(getCard(i));
        }
    }
    
    /**
     * Empty hand checker
     * @return true if empty or false if not
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
        
}
