import java.util.Random;

/** 
 * DiceRoller.java

 * Defines a class of Invoice objects. An Invoice has 
 * a part number, a description, a quantity, and a price per item. 
 */

public class DiceRoller {
	//class-wide constants
	public static final int NUM_ROLLS = 36000;
	public static final int NUM_DICE = 2;

	private static final Random rand = new Random();
	private static int totals[] = new int[13];
	
	public static void main(String[] args){
		
		runSimulation();
		printResults();
	}
	
	private static void runSimulation(){
		for (int i = 1; i <= NUM_ROLLS; i++){
			totals[RollDice()]++;
		}
		
	}
	
	static int RollDice(){
		int total = 0;

		for (int i = 1; i <= NUM_DICE; i++){
			total += rand.nextInt(5) + 1;
		}
		return total;
	}
	
	private static void printResults(){
		
	}
}
