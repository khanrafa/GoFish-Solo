package GoFish;

import java.util.ArrayList;

/**
 * SYST 17796 Project code - Go Fish Card Game. Rafae Khan - 8/9/2021
 *
 */
public abstract class Game {

    private String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


    public abstract void play();


    public abstract void declareWinner();

}//end class
