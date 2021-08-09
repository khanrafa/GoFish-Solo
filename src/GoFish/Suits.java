
package GoFish;

/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
public enum Suits {
    CLUBS("Clubs"),SPADES("Spades"),DIAMONDS("Diamonds"),HEARTS("Hearts");
    
    private String strValue;
    
    private Suits(String strValue) {
        this.strValue = strValue;
    }
    
    public String getStr() {
        return strValue;
    }
}