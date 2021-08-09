/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
package GoFish;

//
///**
// * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
// * game. Students wishing to add to the code should remember to add themselves as a modifier.
// *
// * @author dancye, khanrafa
// */
public abstract class Card 
{
   private String suit; //clubs, spades, diamonds, hearts
   private int value;//1-13


    
    
    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * 
     * @param suit the suit to set
     * 
     */
    public void setSuit(String suit) {
        
       // CardGoFish card = new CardGoFish();
        this.suit = suit;
        // System.out.println(this.suit);
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
        // System.out.println(this.value);
    }
    
  
    @Override
    public abstract String toString();
    
}
