
package GoFish;

/**
 * SYST 17796 Project code - Go Fish Card Game.
 * Rafae Khan - 8/9/2021
 * 
 */
import java.util.Scanner;

public class StartGame {
     
     public static void main(String[] args) {
       
    	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to GoFish! This can currently be played with 1 Human and 1 NPC.");
    	System.out.println("Press Enter to begin");
    	String begin = sc.next();
        GoFish game = new GoFish(begin);
        System.out.println("Lets start!");

        game.play();
    }    
}