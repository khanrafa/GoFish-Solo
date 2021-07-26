package GoFish;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gets players info to start the game
 * @author Rafae K
 */

public class getPlayersInfo {

    private static Scanner input = new Scanner(System.in);
    static ArrayList<Player> players = new ArrayList<>();



    public static ArrayList<Player> getPlayersInfo() {

        //Add Data validation
        System.out.println("How many players are going to play: ");
        int numOfPlayers = input.nextInt();
        System.out.println("How many of those are going to be human: ");
        int numOfHuman = input.nextInt();
        System.out.println("How many of those are going to be computer: ");
        int numOfNPC = input.nextInt();

        for (int i = 1; i <= numOfHuman; i++) {
            System.out.println("Player name: ");
            String playerName = input.nextLine();
            players.add(new Human(playerName));
        }

        for (int i = 1; i <= numOfNPC; i++) {
            players.add(new NPC("NPC"+i));
        }
        
        return players;
    }
}
