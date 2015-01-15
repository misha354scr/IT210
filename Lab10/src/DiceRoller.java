import java.util.Random;

/** 
 * DiceRoller.java

 * Defines a class of Invoice objects. An Invoice has 
 * a part number, a description, a quantity, and a price per item. 
 */

public class DiceRoller {
	//class-wide constants
	
	public static final int NUM_ROLLS = 36000000; 	//the length of the simulation
	public static final int NUM_DICE = 2; 	//the number of dice
	public static final int NUM_SIDES = 6; //sides per die
	
	//the random number generator
	private static final Random rand = new Random();

	//the array that will hold the number of rolls that result
	//in a particular score
	private static int count[] = new int[(NUM_SIDES * NUM_DICE) + 1];
	
	/** the main application method
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		runSimulation();
		printResults();
	}
	
	private static void runSimulation(){
		for (int i = 1; i <= NUM_ROLLS; i++){
			count[RollDice()]++;
		}
		
	}
	
	static int RollDice(){
		int total = 0;

		for (int i = 1; i <= NUM_DICE; i++){
			total += rand.nextInt(NUM_SIDES) + 1;
		}
		return total;
	}
	
	private static void printResults(){
		System.out.printf("%3s%12s%12s%n", "Sum", "Frequency", "Percentage");
		for (int i = 2; i <= NUM_SIDES * 2; i++ ){
			System.out.printf("%3d%12d%12.2f%n", i, count[i], (double)count[i] / NUM_ROLLS * 100);
		}
	
	}
}

//Sum   Frequency  Percentage
//2     1001550        2.78
//3     1999229        5.55
//4     3000864        8.34
//5     3998765       11.11
//6     4999658       13.89
//7     6003451       16.68
//8     4997274       13.88
//9     3998510       11.11
//10     2999240        8.33
//11     2001145        5.56
//12     1000314        2.78