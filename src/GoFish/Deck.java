//package GoFish;
//import java.util.ArrayList;
//
///**
// *
// * @author rafae
// */
//public class Deck extends GroupOfCards {
//    
//    public Deck()
//    {
//        super();
//        generateDeck();
//        super.shuffle();
//    }
//    
//    public void generateDeck(){
//        Suits suit = Suits.CLUBS;
//        Values value = Values.ACE; 
//        
//        for(Suits s: suit.values()){
//            
//            for(Values v : value.values()){
//                
//                GoFishCard card = new GoFishCard(s.getStr(),v.getNumValue());
//                addCard(card);
//               
//            }
//        }
//    }
//}
/*
 * Zhao Wang
 * 991556434
 * SYST17796
 */
package GoFish;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Deck extends GroupOfCards{
    //The group of cards, stored in an ArrayList

    /**
     * 
     * This is the default constructor.
     */
    public Deck()
    {
        super();
        generateDeck();
        super.shuffle();
    }
    
    /**
     * A method that will get the group of 52 cards as an ArrayList
     *      
     * @return the full pack of 52 cards
     */
    
    public void generateDeck(){
        Suits suit = Suits.CLUBS;
        Values value = Values.ACE;
        
        for(Suits s: suit.values()){
                 
            for(Values v : value.values()){
             //System.out.println(s.toString()+" "+v.toString());

                GoFishCard card = new GoFishCard(s.getStr(),v.getNumValue());
                addCard(card);
            }
        }
    }
    
}
