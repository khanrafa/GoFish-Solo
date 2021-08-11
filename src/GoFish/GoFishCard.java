package GoFish;

/**
 * SYST 17796 Project code - Go Fish Card Game. Rafae Khan - 8/9/2021
 *
 */
public class GoFishCard extends Card {

    /**
     * This method contains setSuit and setValue methods inherited from abstract
     * class Card
     *
     * @param s represent suits
     * @param v represent values
     */
    public GoFishCard(String s, int v) {
        setSuit(s);
        setValue(v);
    }

    /**
     * This class inherits the form of card and get the method of suit and value
     *
     * @return the getSuit and getValue method
     */
    @Override
    public String toString() {
        return getSuit() + " " + getValue();
    }
}
