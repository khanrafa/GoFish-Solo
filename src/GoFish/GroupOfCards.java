package GoFish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * SYST 17796 Project code - Go Fish Card Game. Rafae Khan - 8/9/2021
 *
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<GoFishCard> cards = new ArrayList();

    // Group of cards > ArrayList
    public ArrayList<GoFishCard> showCards() {
        return cards;
    }

    //shuffle
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //size of the group of cards (verifying max)     
    public int getSize() {
        return cards.size();
    }

    // Set hand and deck cards
    public void setCards(ArrayList<GoFishCard> cards) {
        this.cards = cards;
    }

    //This method is to add card from deck
    public void addCard(GoFishCard c) {
        cards.add(c);
    }

    //card's position number in ArrayList     
    public GoFishCard getCard(int index) {
        return cards.get(index);
    }

    //remove the target card     
    public GoFishCard removeCard(int index) {
        return cards.remove(index);
    }

    //remove the card from hand 
    public boolean removeCard(GoFishCard c) {
        return cards.remove(c);
    }

    //display hard after each players turn 
    public void displayCards() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(getCard(i));
        }
    }

    //empty hand checker
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
