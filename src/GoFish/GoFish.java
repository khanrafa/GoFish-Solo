package GoFish;

import java.util.Random;
import java.util.Scanner;

/**
 * SYST 17796 Project code - Go Fish Card Game. Rafae Khan - 8/9/2021
 *
 */
public class GoFish extends Game {

    private int numPlayer;
    private static final int INIT_HAND_COUNT = 7;
    int P_book = 0;
    int NPC_book = 0;

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
        Hand P_hand = new Hand(INIT_HAND_COUNT);
        P_hand.generateHandFromDeck(deck);

        //Generate hand(7 cards) for NPC
        Hand NPC_hand = new Hand(INIT_HAND_COUNT);
        NPC_hand.generateHandFromDeck(deck);

        //the loop that represents one turn of GoFish
        boolean keepGaming = true;
        while (keepGaming) {
            boolean P_turn = true;
            boolean NPC_turn = true;

            //player's turn
            while (P_turn) {
                System.out.println("Your Turn\n");

                //player's action if hand is empty
                if (P_hand.isEmpty()) {
                    P_hand.drawFromDeck(deck);
                    System.out.println("Your hand is empty, drawing a card from deck");
                }

                //player's action when a book forms
                if (P_hand.checkBook() > 0) {
                    System.out.println("You have a Book of " + P_hand.checkBook());
                    P_hand.addBook(P_hand.checkBook());
                    P_book++;
                    displayBook();
                }
                //display hand
                System.out.println("Now your hand is: ");
                P_hand.displayCards();

                //check the input card request (player must have card in hand)
                boolean inputChecker = false;
                int P_input = 0;
                while (!inputChecker) {
                    System.out.println("\nPlease enter the value of Card: ");
                    P_input = sc.nextInt();
                    if (P_hand.hasSameValueCard(P_input)) {
                        inputChecker = true;
                    } else {
                        System.out.println("You don't have a card with that value!");
                    }
                }

                //check if opponent has the input card(s) 
                if (NPC_hand.hasSameValueCard(P_input)) {
                    System.out.println("Your opponent has " + P_input);
                    P_hand.getCardsFromOtherHand(NPC_hand, P_input);
                    if (P_hand.checkBook() > 0) {
                        System.out.println("You have a Book of " + P_input);
                        P_hand.addBook(P_input);
                        P_book++;
                        displayBook();
                        if (P_book + NPC_book == 13) {
                            break;
                        }
                    }
                    System.out.println("Now your hand is: ");
                    P_hand.displayCards();

                    System.out.println("You gain another turn.\n");
                } else {
                    System.out.println("Your oppoent doesn't have the card you want!");
                    System.out.println("Go Fish!");
                    P_hand.drawFromDeck(deck);
                    if (P_hand.checkBook() > 0) {
                        System.out.println("You have a Book of " + P_hand.checkBook());
                        P_hand.addBook(P_hand.checkBook());
                        P_book++;
                        displayBook();
                        if (P_book + NPC_book == 13) {
                            break;
                        }
                    } else {
                        P_turn = false;
                    }

                }

            }

            //
            if (P_book + NPC_book == 13) {
                System.out.println("Game Ends!");
                keepGaming = false;
                break;
            }

            System.out.println("Now your hand is: ");
            P_hand.displayCards();
            System.out.println("Your turn is over.");

            System.out.println("-----------------------------------------");

            //NPC player's turn
            while (NPC_turn) {
                System.out.println("Your Opponent's Turn\n");

                //NBC action when hand is empty
                if (NPC_hand.isEmpty()) {
                    NPC_hand.drawFromDeck(deck);
                    System.out.println("Your opponent's hand is empty! Draw a card from a deck!");
                }

                //NPC checks for book
                if (NPC_hand.checkBook() > 0) {
                    System.out.println("Your opponent has a Book of " + NPC_hand.checkBook());
                    NPC_hand.addBook(NPC_hand.checkBook());
                    NPC_book++;
                    displayBook();
                }

                //ai's card request from player
                int aiChosenValue = NPC_hand.getCard(generateRandomNumber(NPC_hand.getSize())).getValue();
                System.out.println("Your opponent wants " + aiChosenValue);
                if (P_hand.hasSameValueCard(aiChosenValue)) {
                    System.out.println("You have " + aiChosenValue);
                    NPC_hand.getCardsFromOtherHand(P_hand, aiChosenValue);
                    if (NPC_hand.checkBook() > 0) {
                        System.out.println("Your opponent has a Book of " + aiChosenValue);
                        NPC_hand.addBook(aiChosenValue);
                        NPC_book++;
                        displayBook();
                        if (P_book + NPC_book == 13) {
                            System.out.println("Game Ends!");
                            keepGaming = false;
                            break;
                        }
                    }
                    System.out.println("Your opponent gains another turn.\n");
                } else {
                    System.out.println("You don't have " + aiChosenValue + "!");
                    System.out.println("Go Fish!");
                    NPC_hand.drawFromDeck(deck);
                    if (NPC_hand.checkBook() > 0) {
                        System.out.println("Your opponent has a Book of " + NPC_hand.checkBook());
                        NPC_hand.addBook(NPC_hand.checkBook());
                        NPC_book++;
                        displayBook();
                        if (P_book + NPC_book == 13) {
                            System.out.println("Game Ends!");
                            keepGaming = false;
                            break;
                        }
                    } else {
                        NPC_turn = false;
                    }
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

    // Winner Declaration     
    @Override
    public void declareWinner() {
        if (P_book > NPC_book) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose!");
        }
    }

    //Score Counter     
    public void displayBook() {
        System.out.println("Your Book: " + P_book);
        System.out.println("Opponent Book: " + NPC_book);
    }
}
