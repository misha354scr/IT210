import java.util.Random;

/** 
 * DiceRoller.java

 * An application that simulates the rolling of dice.  
 * Number of dice, number of sides per die, and number of
 * rolls are specified as class-wide constants
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
	
	/**
	 * steps through all simulation steps,
	 * For each steps, adds 1 to the counter array
	 * element whose index == the roll score
	 */
	private static void runSimulation(){
		for (int i = 1; i <= NUM_ROLLS; i++){
			count[RollDice()]++;
		}		
	}
	
	/**
	 * generates a dice roll
	 * @return a number from NUM_DICE to NUM_SIDES * NUM_DICE
	 */
	static int RollDice(){
		int total = 0;

		for (int i = 1; i <= NUM_DICE; i++){
			total += rand.nextInt(NUM_SIDES) + 1;
		}
		return total;
	}
	
	/**
	 * prints the results of the simulation
	 */
	private static void printResults(){
		System.out.printf("%3s%12s%12s%n", "Sum", "Frequency", "Percentage");
		for (int i = NUM_DICE; i <= NUM_SIDES * 2; i++ ){
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