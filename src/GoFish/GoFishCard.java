///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package project;
//
///**
// *
// * @modifier Zhao Wang 
// */
//public class GoFishCard extends Card {
//	/**
//	 * This method contains setSuit and setValue methods  
//	 * inherited from abstract class Card
//	 * @param s represent suits
//	 * @param v represent values	
//	 */
//    public GoFishCard(String s,int v) {
//        setSuit(s);
//        setValue(v);
//    }
//    
//    /**
//     * This class inherits the form of card 
//     * and get the method of suit and value
//     * @return the getSuit and getValue method
//     */
//    @Override
//    public String toString() {
//        return getSuit()+" "+getValue();
//    }
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoFish;

/**
 *
 * @modifier Zhao Wang 
 */
public class GoFishCard extends Card {
	/**
	 * This method contains setSuit and setValue methods  
	 * inherited from abstract class Card
	 * @param s represent suits
	 * @param v represent values	
	 */
    public GoFishCard(String s,int v) {
        setSuit(s);
        setValue(v);
    }
    
    /**
     * This class inherits the form of card 
     * and get the method of suit and value
     * @return the getSuit and getValue method
     */
    @Override
    public String toString() {
        return getSuit()+" "+getValue();
    }
}


