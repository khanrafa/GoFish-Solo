
package GoFish;

/**
 *
 * @author rafae
 */
public enum Suits {
    CLUBS("Clubs"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts");
    
    private String strValue;
    
    private Suits(String strValue) {
        this.strValue = strValue;
    }
    
    public String getStr() {
        return strValue;
    }
}