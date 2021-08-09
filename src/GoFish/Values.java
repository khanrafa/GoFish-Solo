
package GoFish;

/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
public enum Values {
    ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13);
    
    private int numValue;
    
    private Values(int numValue) {
        this.numValue=numValue;
    }
    
    public int getNumValue() {
        return numValue;
    }
}