package edu.nhti.craps;
import java.io.IOException;

/**
 * An application that tests the craps game in Game.java
 * @author Mike
 *
 */
public class GameTester {

	public static void main(String [] args) throws IOException{
		Game craps = new Game();
		craps.play();
	}
}

//A losing example:

//Come Out:
//You rolled a 3 and a 6, for a total of 9. That's a(n) Nine.
//
//The point is 9
//You rolled a 6 and a 5, for a total of 11. That's a(n) Yo-Leven.
//You rolled a 6 and a 5, for a total of 11. That's a(n) Yo-Leven.
//You rolled a 5 and a 2, for a total of 7. That's a(n) Seven Out.
//
//You lose!

//A winning example.

//Come Out:
//You rolled a 5 and a 5, for a total of 10. That's a(n) Hard Ten.
//
//The point is 10
//You rolled a 2 and a 3, for a total of 5. That's a(n) Five.
//You rolled a 4 and a 6, for a total of 10. That's a(n) Easy Ten.
//
//You win!
