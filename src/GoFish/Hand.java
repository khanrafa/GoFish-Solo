package GoFish;

/**
 * SYST 17796 Project code - Go Fish Card Game. Rafae Khan - 8/9/2021
 *
 */
public class Hand extends GroupOfCards {
    //initialize the enum suit and initial hand size

    Suits suit = Suits.CLUBS;
    private int initialHandSize;

    /**
     * This method is to initialize hand size.
     *
     * @param size: the size of the hand
     */
    public Hand(int size) {
        super();
        initialHandSize = size;
    }

    /**
     * Hand Generator based on generated deck
     *
     * @param deck: represent total cards (52) as a deck
     */
    public void generateHandFromDeck(Deck deck) {
        for (int i = 0; i < initialHandSize; i++) {
            drawFromDeck(deck);
        }
    }

    /**
     * Card draw
     *
     * @param deck: represent total cards (52) as a deck
     */
    public void drawFromDeck(Deck deck) {
        GoFishCard temp = deck.getCard(0);
        deck.removeCard(0);
        addCard(temp);

    }

    /**
     * input value check (player must have card requested)
     *
     * @param value: the card's value
     */
    public boolean hasSameValueCard(int value) {
        for (int i = 0; i < getSize(); i++) {
            if (getCard(i).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Moving requested card
     *
     * @param other: the opponent's hand
     * @param value: the card that player wants
     */
    public void getCardsFromOtherHand(Hand other, int value) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < other.getSize(); i++) {
                if (other.getCard(i).getValue() == value) {
                    GoFishCard temp = other.getCard(i);
                    addCard(temp);
                    other.removeCard(temp);
                    break;
                }
            }
        }
    }

    /**
     * Book check
     *
     * @return a value that represent "not a book" scenario
     */
    public int checkBook() {
        int value = 0;
        for (int i = 0; i < getSize(); i++) {
            value = getCard(i).getValue();
            if (countCardsOfValue(value) == 4) {
                return value;
            }
        }
        return -1;
    }

    /**
     * Removing book cards from play
     *
     * @param value: the card to be exact (from ACE to KING)
     */
    public void addBook(int value) {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < getSize(); i++) {
                if (getCard(i).getValue() == value) {
                    removeCard(getCard(i));
                    break;
                }
            }
        }
    }

    /**
     * Player hand count
     *
     * @param value
     * @return
     */
    public int countCardsOfValue(int value) {
        int count = 0;
        for (int i = 0; i < getSize(); i++) {
            if (getCard(i).getValue() == value) {
                count++;
            }
        }
        return count;
    }

}
