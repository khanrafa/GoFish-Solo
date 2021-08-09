//
//  
///*
// * Zhao Wang
// * 991556434
// * SYST17796 
// */
//package GoFish;
//
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
///**
// *
// * @author user
// */
//public class GoFish extends Game {
//
//
//    private int numPlayer;
//    private static final int INIT_HAND_NUM = 7;
//    int bookP = 0;
//    int bookAI = 0;
//
//    public GoFish(String givenName) {
//        super(givenName);
//    }
//
//    //Two hands of 7 cards are created for 2 players. If we want more player, 
//    //this method can be modified
//    public void play() {
//        
//                Scanner sc = new Scanner(System.in);
//                //Genereate a deck of 52 cards
//                Deck deck = new Deck();
//                
//                
//                System.out.println("=======================");
//                //Generate hand1(7 cards) for Player 1
//                Hand handP = new Hand(INIT_HAND_NUM);
//                handP.generateHandFromDeck(deck);
//                
//    
//
//                //Generate hand2(7 cards) for AI
//                Hand handAI = new Hand(INIT_HAND_NUM);
//                handAI.generateHandFromDeck(deck);
//                
//                
//                //the loop that represents one turn of goFish
//                boolean keepGaming = true;
//                while(keepGaming) {
//                    boolean pTerm = true;
//                    boolean aiTerm = true;
//                    
//                    //player's turn
//                    while(pTerm) {
//                        System.out.println("Your Turn\n");
//                     
//                        //player's action if hand's empty
//                        if(handP.isEmpty()) {
//                            handP.drawFromDeck(deck);
//                            System.out.println("Your hand is empty! Draw a card from a deck!");
//                        }
//                        
//                        //player's action when a book forms
//                        if (handP.checkBook()>0) {
//                            System.out.println("You have a Book of "+handP.checkBook());
//                            handP.addBook(handP.checkBook());
//                            bookP++;
//                            displayBook();
//                        }
//                        //display hand
//                        System.out.println("Now your hand is: ");
//                        handP.displayCards();
//                        
//                        //check the input card value to see if there is also same value card(s) in player's hand
//                        boolean inputCheckFlag = false;
//                        int pInputValue = 0;
//                        while(!inputCheckFlag) {
//                            System.out.println("\nPlease enter the value of Card: ");
//                            pInputValue = sc.nextInt();
//                            if (handP.hasSameValueCard(pInputValue)) {
//                                inputCheckFlag = true;
//                            }
//                            else {
//                                System.out.println("You don't have a card with that value!");
//                            }
//                        }
//                        
//                        //check if opponent has the input card(s) 
//                        if (handAI.hasSameValueCard(pInputValue)) {
//                            System.out.println("Your opponent has "+pInputValue);
//                            handP.getCardsFromOtherHand(handAI, pInputValue);
//                            if (handP.checkBook()>0) {
//                                System.out.println("You have a Book of "+pInputValue);
//                                handP.addBook(pInputValue);
//                                bookP++;
//                                displayBook();
//                                if (bookP+bookAI == 13) {
//                                    break;
//                                }
//                            }
//                            System.out.println("Now your hand is: ");
//                            handP.displayCards();
//                            
//                            System.out.println("You gain another turn.\n");
//                        }//end of if 
//                        else {
//                            System.out.println("Your oppoent doesn't have the card you want!");
//                            System.out.println("Go Fish!");
//                            handP.drawFromDeck(deck);
//                            if (handP.checkBook()>0) {
//                                System.out.println("You have a Book of "+handP.checkBook());
//                                handP.addBook(handP.checkBook());
//                                bookP++;
//                                displayBook();
//                                if (bookP+bookAI == 13) {
//                                    break;
//                                }
//                            }
//                            else pTerm = false;
//                            
//                        }//end of else
//                        
//                    }//end of while(pTerm)
//                    
//                    //
//                    if(bookP+bookAI == 13) {
//                        System.out.println("Game Ends!");
//                        keepGaming = false;
//                        break;
//                    }
//                    
//                    System.out.println("Now your hand is: ");
//                    handP.displayCards();
//                    System.out.println("Your turn is over.");
//                    
//                    System.out.println("=======================");
//                    
//                    //ai player's turn
//                    while (aiTerm) {
//                        System.out.println("Your Opponent's Turn\n");
//                        
//                        //ai's action when hand is empty
//                        if(handAI.isEmpty()) {
//                            handAI.drawFromDeck(deck);
//                            System.out.println("Your opponent's hand is empty! Draw a card from a deck!");
//                        }//end of if
//                        
//                        //ai checks for book
//                        if (handAI.checkBook()>0) {
//                            System.out.println("Your opponent has a Book of "+handAI.checkBook());
//                            handAI.addBook(handAI.checkBook());
//                            bookAI++;
//                            displayBook();
//                        }//end of if
//                        
//                        //ai's action to choose card from player
//                        int aiChosenValue = handAI.getCard(generateRandomNumber
//                                            (handAI.getSize())).getValue();
//                        System.out.println("Your opponent wants "+aiChosenValue);
//                        if (handP.hasSameValueCard(aiChosenValue)) {
//                            System.out.println("You have "+aiChosenValue);
//                            handAI.getCardsFromOtherHand(handP, aiChosenValue);
//                            if (handAI.checkBook()>0) {
//                                System.out.println("Your opponent has a Book of "+aiChosenValue);
//                                handAI.addBook(aiChosenValue);
//                                bookAI++;
//                                displayBook();
//                                if (bookP+bookAI == 13) {
//                                    System.out.println("Game Ends!");
//                                    keepGaming = false;
//                                    break;
//                                }
//                            }
//                            System.out.println("Your opponent gains another turn.\n");
//                        }//end of if
//                        //
//                        else {
//                            System.out.println("You don't have "+aiChosenValue+"!");
//                            System.out.println("Go Fish!");
//                            handAI.drawFromDeck(deck);
//                            if (handAI.checkBook()>0) {
//                                System.out.println("Your opponent has a Book of "+handAI.checkBook());
//                                handAI.addBook(handAI.checkBook());
//                                bookAI++;
//                                displayBook();
//                                if (bookP+bookAI == 13) {
//                                    System.out.println("Game Ends!");
//                                    keepGaming = false;
//                                    break;
//                                }
//                            }
//                            else aiTerm = false;
//                            System.out.println("Your opponent's turn is over.");
//                        }//end of else
//                    }//end of while(aiTerm)
//                    System.out.println("=======================");
//
//                }//end of while(keepGaming)
//                declareWinner();
//    }
//      // Built-in Random class is used to create random numbers
//    public int generateRandomNumber(int maxVal) {
//        Random rdm = new Random();
//        return rdm.nextInt(maxVal);
//    }
//
//
//    /**
//     * When the game is over, use this method to declare and display a winning
//     * player.
//     */
//    public void declareWinner() {
//        if(bookP>bookAI) 
//            System.out.println("You Win!");
//        else
//            System.out.println("You Lose!");
//    }
//    /**
//     * This method display the number of books
//     * each player has.
//     */
//    public void displayBook() {
//        System.out.println("Your Book: "+bookP);
//        System.out.println("Opponent Book: "+bookAI);
//    }
//}
/*
 * Zhao Wang
 * 991556434
 * SYST17796 
 */
package GoFish;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class GoFish extends Game {


    private int numPlayer;
    private static final int INIT_HAND_NUM = 7;
    int bookP = 0;
    int bookAI = 0;

    public GoFish(String givenName) {
        super(givenName);
    }

    //Two hands of 7 cards are created for 2 players. If we want more player, 
    //this method can be modified
    public void play() {
        
                Scanner sc = new Scanner(System.in);
                //Genereate a deck of 52 cards
                Deck deck = new Deck();
                
                
                System.out.println("=======================");
                //Generate hand1(7 cards) for Player 1
                Hand handP = new Hand(INIT_HAND_NUM);
                handP.generateHandFromDeck(deck);
                
    

                //Generate hand2(7 cards) for AI
                Hand handAI = new Hand(INIT_HAND_NUM);
                handAI.generateHandFromDeck(deck);
                
                
                //the loop that represents one turn of goFish
                boolean keepGaming = true;
                while(keepGaming) {
                    boolean pTerm = true;
                    boolean aiTerm = true;
                    
                    //player's turn
                    while(pTerm) {
                        System.out.println("Your Turn\n");
                     
                        //player's action if hand's empty
                        if(handP.isEmpty()) {
                            handP.drawFromDeck(deck);
                            System.out.println("Your hand is empty! Draw a card from a deck!");
                        }
                        
                        //player's action when a book forms
                        if (handP.checkBook()>0) {
                            System.out.println("You have a Book of "+handP.checkBook());
                            handP.addBook(handP.checkBook());
                            bookP++;
                            displayBook();
                        }
                        //display hand
                        System.out.println("Now your hand is: ");
                        handP.displayCards();
                        
                        //check the input card value to see if there is also same value card(s) in player's hand
                        boolean inputCheckFlag = false;
                        int pInputValue = 0;
                        while(!inputCheckFlag) {
                            System.out.println("\nPlease enter the value of Card: ");
                            pInputValue = sc.nextInt();
                            if (handP.hasSameValueCard(pInputValue)) {
                                inputCheckFlag = true;
                            }
                            else {
                                System.out.println("You don't have a card with that value!");
                            }
                        }
                        
                        //check if opponent has the input card(s) 
                        if (handAI.hasSameValueCard(pInputValue)) {
                            System.out.println("Your opponent has "+pInputValue);
                            handP.getCardsFromOtherHand(handAI, pInputValue);
                            if (handP.checkBook()>0) {
                                System.out.println("You have a Book of "+pInputValue);
                                handP.addBook(pInputValue);
                                bookP++;
                                displayBook();
                                if (bookP+bookAI == 13) {
                                    break;
                                }
                            }
                            System.out.println("Now your hand is: ");
                            handP.displayCards();
                            
                            System.out.println("You gain another turn.\n");
                        }//end of if 
                        else {
                            System.out.println("Your oppoent doesn't have the card you want!");
                            System.out.println("Go Fish!");
                            handP.drawFromDeck(deck);
                            if (handP.checkBook()>0) {
                                System.out.println("You have a Book of "+handP.checkBook());
                                handP.addBook(handP.checkBook());
                                bookP++;
                                displayBook();
                                if (bookP+bookAI == 13) {
                                    break;
                                }
                            }
                            else pTerm = false;
                            
                        }//end of else
                        
                    }//end of while(pTerm)
                    
                    //
                    if(bookP+bookAI == 13) {
                        System.out.println("Game Ends!");
                        keepGaming = false;
                        break;
                    }
                    
                    System.out.println("Now your hand is: ");
                    handP.displayCards();
                    System.out.println("Your turn is over.");
                    
                    System.out.println("=======================");
                    
                    //ai player's turn
                    while (aiTerm) {
                        System.out.println("Your Opponent's Turn\n");
                        
                        //ai's action when hand is empty
                        if(handAI.isEmpty()) {
                            handAI.drawFromDeck(deck);
                            System.out.println("Your opponent's hand is empty! Draw a card from a deck!");
                        }//end of if
                        
                        //ai checks for book
                        if (handAI.checkBook()>0) {
                            System.out.println("Your opponent has a Book of "+handAI.checkBook());
                            handAI.addBook(handAI.checkBook());
                            bookAI++;
                            displayBook();
                        }//end of if
                        
                        //ai's action to choose card from player
                        int aiChosenValue = handAI.getCard(generateRandomNumber
                                            (handAI.getSize())).getValue();
                        System.out.println("Your opponent wants "+aiChosenValue);
                        if (handP.hasSameValueCard(aiChosenValue)) {
                            System.out.println("You have "+aiChosenValue);
                            handAI.getCardsFromOtherHand(handP, aiChosenValue);
                            if (handAI.checkBook()>0) {
                                System.out.println("Your opponent has a Book of "+aiChosenValue);
                                handAI.addBook(aiChosenValue);
                                bookAI++;
                                displayBook();
                                if (bookP+bookAI == 13) {
                                    System.out.println("Game Ends!");
                                    keepGaming = false;
                                    break;
                                }
                            }
                            System.out.println("Your opponent gains another turn.\n");
                        }//end of if
                        //
                        else {
                            System.out.println("You don't have "+aiChosenValue+"!");
                            System.out.println("Go Fish!");
                            handAI.drawFromDeck(deck);
                            if (handAI.checkBook()>0) {
                                System.out.println("Your opponent has a Book of "+handAI.checkBook());
                                handAI.addBook(handAI.checkBook());
                                bookAI++;
                                displayBook();
                                if (bookP+bookAI == 13) {
                                    System.out.println("Game Ends!");
                                    keepGaming = false;
                                    break;
                                }
                            }
                            else aiTerm = false;
                            System.out.println("Your opponent's turn is over.");
                        }//end of else
                    }//end of while(aiTerm)
                    System.out.println("=======================");

                }//end of while(keepGaming)
                declareWinner();
    }
      // Built-in Random class is used to create random numbers
    public int generateRandomNumber(int maxVal) {
        Random rdm = new Random();
        return rdm.nextInt(maxVal);
    }


    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public void declareWinner() {
        if(bookP>bookAI) 
            System.out.println("You Win!");
        else
            System.out.println("You Lose!");
    }
    /**
     * This method display the number of books
     * each player has.
     */
    public void displayBook() {
        System.out.println("Your Book: "+bookP);
        System.out.println("Opponent Book: "+bookAI);
    }
}
