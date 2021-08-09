///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GoFish;
//
///**
// *
// * @author 
// */
//public class Hand extends GroupOfCards{
//	//initialize the enum suit and initial hand size
//    Suits suit = Suits.CLUBS;
//    private int initialHandSize;
//    
//    /**
//     * This method is to initialise hand size.
//     * 
//     * @param size: the size of the hand
//     */
//    public Hand(int size) {
//        super();
//        initialHandSize=size;
//    }
//    
//    
//    /**
//     * This method is to generate 7 cards from deck 
//     * via drawFromDeck method
//     * 
//     * @param deck: represent total cards (52) as a deck
//     */
//    public void generateHandFromDeck(Deck deck) {
//        for (int i = 0;i < initialHandSize;i++) {
//            drawFromDeck(deck);
//        }
//    }
//    
//    /**
//     * This method is to execute card drawing for 
//     * not only generateHandFromDeck method,
//     * but also drawing card when "Go Fish" action 
//     * triggers.
//     * 
//     * @param deck: represent total cards (52) as a deck
//     */
//    public void drawFromDeck(Deck deck) {
//        GoFishCard temp = deck.getCard(0);
//        deck.removeCard(0);
//        addCard(temp);
//        
//    }
//    
//    /**
//     * This method is to detect whether there is card
//     * in player's hand that is the same as the value of 
//     * the card player called
//     * @param value: the card's value
//     * @return false if the player doesn't have the 
//     * 		   card you called in your hand
//     */
//    public boolean hasSameValueCard(int value) {
//        for (int i = 0;i < getSize();i++) {
//            if(getCard(i).getValue() == value) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    /**
//     * This method is to get the card(s) that player wants 
//     * and add it/them into player's hand
//     * @param other: the opponent's hand
//     * @param value: the card that player wants 
//     */
//    public void getCardsFromOtherHand(Hand other, int value) {
//        for (int j = 0;j < 3;j++) {
//            for(int i = 0;i<other.getSize();i++) {
//                if(other.getCard(i).getValue()==value) {
//                    GoFishCard temp = other.getCard(i);
//                    addCard(temp);
//                    other.removeCard(temp);
//                    break;
//                }
//            }
//        }
//    }
//    
//    
//    /**
//     * This method is to check whether there is a 4-card
//     * combination called "book" occurs 
//     * @return a value that represent "not a book" scenario
//     */
//    public int checkBook() {
//        int value = 0;
//        for(int i = 0;i< getSize();i++) {
//            value = getCard(i).getValue();
//            if(countCardsOfValue(value)== 4) {
//                return value;
//            }
//        }
//        return -1;
//    }
//    
//    /**
//     * This method is to remove the 4 cards that has already 
//     * become a book. 
//     * @param value: the card to be exact (from ACE to KING)
//     */
//    public void addBook(int value) {
//        for (int j = 0;j < 4;j++) {
//            for(int i = 0;i<getSize();i++) {
//                if(getCard(i).getValue()==value) {
//                    removeCard(getCard(i));
//                    break;
//                }
//            }
//        }
//    }
//    
//    /**
//     * This method is to count whether there is a card that 
//     * is increased in player's hand.
//     * @param value
//     * @return
//     */
//    public int countCardsOfValue(int value) {
//        int count = 0;
//        for (int i = 0;i < getSize();i++) {
//            if(getCard(i).getValue() == value) {
//                count++;
//            }
//        }
//        return count;
//    }
//    
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoFish;

/**
 *
 * @author 
 */
public class Hand extends GroupOfCards{
	//initialize the enum suit and initial hand size
    Suits suit = Suits.CLUBS;
    private int initialHandSize;
    
    /**
     * This method is to initialise hand size.
     * 
     * @param size: the size of the hand
     */
    public Hand(int size) {
        super();
        initialHandSize=size;
    }
    
    
    /**
     * This method is to generate 7 cards from deck 
     * via drawFromDeck method
     * 
     * @param deck: represent total cards (52) as a deck
     */
    public void generateHandFromDeck(Deck deck) {
        for (int i = 0;i < initialHandSize;i++) {
            drawFromDeck(deck);
        }
    }
    
    /**
     * This method is to execute card drawing for 
     * not only generateHandFromDeck method,
     * but also drawing card when "Go Fish" action 
     * triggers.
     * 
     * @param deck: represent total cards (52) as a deck
     */
    public void drawFromDeck(Deck deck) {
        GoFishCard temp = deck.getCard(0);
        deck.removeCard(0);
        addCard(temp);
        
    }
    
    /**
     * This method is to detect whether there is card
     * in player's hand that is the same as the value of 
     * the card player called
     * @param value: the card's value
     * @return false if the player doesn't have the 
     * 		   card you called in your hand
     */
    public boolean hasSameValueCard(int value) {
        for (int i = 0;i < getSize();i++) {
            if(getCard(i).getValue() == value) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method is to get the card(s) that player wants 
     * and add it/them into player's hand
     * @param other: the opponent's hand
     * @param value: the card that player wants 
     */
    public void getCardsFromOtherHand(Hand other, int value) {
        for (int j = 0;j < 3;j++) {
            for(int i = 0;i<other.getSize();i++) {
                if(other.getCard(i).getValue()==value) {
                    GoFishCard temp = other.getCard(i);
                    addCard(temp);
                    other.removeCard(temp);
                    break;
                }
            }
        }
    }
    
    
    /**
     * This method is to check whether there is a 4-card
     * combination called "book" occurs 
     * @return a value that represent "not a book" scenario
     */
    public int checkBook() {
        int value = 0;
        for(int i = 0;i< getSize();i++) {
            value = getCard(i).getValue();
            if(countCardsOfValue(value)== 4) {
                return value;
            }
        }
        return -1;
    }
    
    /**
     * This method is to remove the 4 cards that has already 
     * become a book. 
     * @param value: the card to be exact (from ACE to KING)
     */
    public void addBook(int value) {
        for (int j = 0;j < 4;j++) {
            for(int i = 0;i<getSize();i++) {
                if(getCard(i).getValue()==value) {
                    removeCard(getCard(i));
                    break;
                }
            }
        }
    }
    
    /**
     * This method is to count whether there is a card that 
     * is increased in player's hand.
     * @param value
     * @return
     */
    public int countCardsOfValue(int value) {
        int count = 0;
        for (int i = 0;i < getSize();i++) {
            if(getCard(i).getValue() == value) {
                count++;
            }
        }
        return count;
    }
    
}
