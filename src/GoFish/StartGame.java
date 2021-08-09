
package GoFish;

/**
 *
 * @author rafae
 */
import java.util.Scanner;

/**
 *
 * @author user
 */
public class StartGame {
     
     public static void main(String[] args) {
       
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	System.out.println("Press 1 to begin");
    	String begin = sc.next();
        GoFish game = new GoFish(begin);
        System.out.println("Computer acts as one player");
        System.out.println("Go fish begins.");

        game.play();
    }    
}