/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 *
 */
package GoFish;

public abstract class Card {

    private String suit; //clubs, spades, diamonds, hearts
    private int value;//1-13

    /**
     * @return suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
        // System.out.println(this.value);
    }

    @Override
    public abstract String toString();

}
