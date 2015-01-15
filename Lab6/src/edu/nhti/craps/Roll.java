package edu.nhti.craps;

import java.util.Random;

/**
 * Roll.java
 * A class that, when instantiated, 
 * models the rolling of two dice.
 * After it's created, the instance stores the result of
 * the roll as an enumeration constant.  The names of the enumeration
 * constants correspond to the names of the rolls in craps
 * @author Mike
 *
 */
public class Roll {

	/**
	 * an enumeration the name of whose constants
	 * correspond to the names of the rolls in craps.
	 * Note that some point values have different
	 * names, depending on the stage of the game
	 * @author Mike
	 */
	public enum Rolls{
		SNAKE_EYES("Snake Eyes"),	//two ones
		ACE_DEUCE("Ace Deuce"),	// a 1 and a 2
		EASY_FOUR("Easy Four"),	// a 1 and a 3
		HARD_FOUR("Hard Four"),	//two 2
		FIVE("Five"),		//any 5 		
		EASY_SIX("Easy Six"), 	//1 and 5 OR 2 and 4
		HARD_SIX("Hard Six"), //two 3
		SEVEN_OUT("Seven Out"), //any 7 rolled in the point phase
		NATURAL("Natural"), //a 7 or 11 rolled in the come out phase
		EASY_EIGHT("Easy Eight"), //2 and 6, or 3 and 5
		HARD_EIGHT("Hard Eight"), //two 4's
		NINE("Nine"), //3 and 6, or 4 and 5
		EASY_TEN("Easy Ten"), //4 and 6
		HARD_TEN("Hard Ten"), //two 5's
		YO_LEVEN("Yo-Leven"), //5 and 6
		BOXCARS("Boxcars"); //two 6's

		//Private data fields of enum Rolls
		private String name; //stores the name of the roll
		
		/**
		 * private constructor for enum Rolls constants
		 * @param name - the name of a particular roll
		 */
		private Rolls(String name){
			this.name = name;
		}
		
		/**
		 * returns a string with the name of the roll
		 */
		public String toString(){
			return name;
		}
	} //end of enum Rolls
	
	//private data fields of Roll class
	
	//stores the outcome of each die
	private int number1, number2;
	
	//stores the status of the game in
	//which the roll was made. Possible values are
	//Game.COME_OUT, and Game.POINT
	private Game.GameStatus gameStatus;

	//stores the roll name of the current roll
	private Rolls result;

	//Public methods
	
	/**
	 * returns the name of this roll
	 * @return
	 */
	public Rolls getResult(){
		return result;
	}
	
	/**
	 * Returns the point value of this roll
	 * @return
	 */
	public int getValue(){
		return number1 + number2;
	}
	
	/**
	 * A string informing the player of the point value and name of this roll
	 */
	public String toString(){
		return String.format("You rolled a %d and a %d, for a total of %d. "
				+ "That's a(n) %s.", number1, number2, number1 + number2, result.toString());		
	}
	
	//Private methods
	
	/**
	 * Determines if an 11 is a Natural (if the game is in the come-out phase)
	 * or a Yo-Leven (if the game is in the point phase)
	 * @return
	 * @throws IllegalStateException
	 */
	private Rolls NaturalOrYoLeven() throws IllegalStateException{
		
		if (number1 + number2 != 11)
		//the method was called by mistake
			throw new IllegalStateException("Checking for natural 11 on a" +
					"that's not an 11");
		
		if (gameStatus == Game.GameStatus.COME_OUT)
		//the game was in the come out phase. Natural
			return Rolls.NATURAL;
		else
		//the game is in the point phase. Yo-Leven.
			return Rolls.YO_LEVEN;
	}

	/**
	 * Determines if a 7 is a Natural (if the game is in the come-out phase)
	 * or a Seven-out (if the game is in the point phase)
	 * @return
	 * @throws IllegalStateException - if roll and a 7
	 */
	private Rolls NaturalOrSevenOut(){

		if (number1 + number2 != 7)
		//method was called by mistake
			throw new IllegalStateException("Checking for natural 7  on roll" +
		"that's not a 7");

		if (gameStatus == Game.GameStatus.COME_OUT)
		//the game is in the come-out phase. Natural	
			return Rolls.NATURAL;
		else
		//the game is in the point phase. Seven-Out
			return Rolls.SEVEN_OUT;
	}
	
	/**
	 * Public constructor. Generates two random numbers 1 
	 * through 6 and assigns them to individual die outcomes.
	 * Depending on the sum of die point values and the game status
	 * assigns a name to this roll
	 * @param gameStatus the status of the game (come-out or point)
	 */
	public Roll(Game.GameStatus gameStatus){
		//store the game status
		this.gameStatus = gameStatus;
		
		//create a random number generator
		Random randomGenerator = new Random();
	
		//the values of the two die rolls
		number1 = randomGenerator.nextInt(6) + 1;
		number2 = randomGenerator.nextInt(6) + 1;
	
		//holds the lower of the two die values
		int lowerDie = Math.min(number1, number2); 
	
		//holds the lower of the two die values
		int higherDie = Math.max(number1, number2);
				
		//Decide the name of the roll
	
		if (lowerDie == 1){
							
			switch (higherDie){
				case 1:
					result = Rolls.SNAKE_EYES;
					break;
				case 2:
					result = Rolls.ACE_DEUCE;
					break;
				case 3:
					result = Rolls.EASY_FOUR;
					break;
				case 4:
					result = Rolls.FIVE;
					break;
				case 5:
					result = Rolls.EASY_SIX;
					break;
				case 6:
					result = NaturalOrSevenOut();
					break;
				}
			}
	
		else if (lowerDie == 2){
			switch(higherDie){
				case 2:
					result = Rolls.HARD_FOUR;
					break;
				case 3:
					result = Rolls.FIVE;
					break;
				case 4:
					result = Rolls.EASY_SIX;
					break;
				case 5:
					result = NaturalOrSevenOut();
					break;
				case 6:
					result = Rolls.EASY_EIGHT;
					break;
			}
		}
			
		else if (lowerDie == 3){
			switch (higherDie){
				case 3:
					result = Rolls.HARD_SIX;
					break;
				case 4:
					result = NaturalOrSevenOut();
					break;
				case 5:
					result = Rolls.EASY_EIGHT;
					break;
				case 6:
					result = Rolls.NINE;
					break;
			}
		}
				
		else if (lowerDie == 4){
			switch (higherDie){
				case 4:
					result = Rolls.HARD_EIGHT;
					break;
				case 5:
					result = Rolls.NINE;
					break;
				case 6:
					result = Rolls.EASY_TEN;
					break;
			}
		}
			
		else if (lowerDie == 5){
			switch(higherDie){
				case 5:
					result = Rolls.HARD_TEN;
					break;
				case 6:
					result = NaturalOrYoLeven();
					break;
			}
		}
		
		//both dices are sixes
		else{
			result = Rolls.BOXCARS;
		}	
	}
}
