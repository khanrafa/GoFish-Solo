
package GoFish;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
public class GoFish extends Game {


    private int numPlayer;
    private static final int INIT_HAND_NUM = 7;
    int bookP = 0;
    int bookAI = 0;

    public GoFish(String givenName) {
        super(givenName);
    }

    //Two hands of 7 cards are created for 2 players. Game is currently coded to work with 1 Human player and 1 NPC. This can be changed in the future as needed. 
    public void play() {
        
                Scanner sc = new Scanner(System.in);
                //Genereate a deck of 52 cards
                Deck deck = new Deck();
                
                
                System.out.println("-----------------------------------------");
                //Generate hand(7 cards) for Player 1
                Hand handP = new Hand(INIT_HAND_NUM);
                handP.generateHandFromDeck(deck);
                
    

                //Generate hand(7 cards) for AI
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
                     
                        //player's action if hand is empty
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
                        
                        //check the input card request (player must have card in hand)
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
                        } 
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
                            
                        }
                        
                    }
                    
                    //
                    if(bookP+bookAI == 13) {
                        System.out.println("Game Ends!");
                        keepGaming = false;
                        break;
                    }
                    
                    System.out.println("Now your hand is: ");
                    handP.displayCards();
                    System.out.println("Your turn is over.");
                    
                    System.out.println("-----------------------------------------");
                    
                    //NPC player's turn
                    while (aiTerm) {
                        System.out.println("Your Opponent's Turn\n");
                        
                        //NBC action when hand is empty
                        if(handAI.isEmpty()) {
                            handAI.drawFromDeck(deck);
                            System.out.println("Your opponent's hand is empty! Draw a card from a deck!");
                        }
                        
                        //NPC checks for book
                        if (handAI.checkBook()>0) {
                            System.out.println("Your opponent has a Book of "+handAI.checkBook());
                            handAI.addBook(handAI.checkBook());
                            bookAI++;
                            displayBook();
                        }
                        
                        //ai's card request from player
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
                        }
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
                        }
                    }
                    System.out.println("-----------------------------------------");

                }
                declareWinner();
    }
      // Built-in Random class is used to create random numbers 
    public int generateRandomNumber(int maxVal) {
        Random rdm = new Random();
        return rdm.nextInt(maxVal);
    }


    /**
     * Winner Declaration
     */
    public void declareWinner() {
        if(bookP>bookAI) 
            System.out.println("You Win!");
        else
            System.out.println("You Lose!");
    }
    /**
     * Score Counter
     */
    public void displayBook() {
        System.out.println("Your Book: "+bookP);
        System.out.println("Opponent Book: "+bookAI);
    }
}
