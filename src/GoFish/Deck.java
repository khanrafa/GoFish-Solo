
/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
package GoFish;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Deck extends GroupOfCards{
    //Deck Construction - Generates 52 cards in an arraylist
    public Deck()
    {
        super();
        generateDeck();
        super.shuffle();
    }
    
    public void generateDeck(){
        Suits suit = Suits.CLUBS;
        Values value = Values.ACE;
        
        for(Suits s: suit.values()){
                 
            for(Values v : value.values()){
             

                GoFishCard card = new GoFishCard(s.getStr(),v.getNumValue());
                addCard(card);
            }
        }
    }
    
}
