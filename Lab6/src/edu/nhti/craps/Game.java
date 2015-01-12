package edu.nhti.craps;

/** 
 * Game.java

 * Defines a class that simulates a game of craps.
 * Rules can be fount at http://en.wikipedia.org/wiki/Craps 
 */
public class Game {

	/**An enum that has two possible values,
	representing the two phases of the game
	*/
	public enum GameStatus{
		COME_OUT(), //The come-out phase (the first roll)
		POINT(); //the point phase (subsequent rolls)						 
	}

	//stores the status of the game (point or come-out)
	private GameStatus gameStatus;
	
	/**
	 * write a "player wins" to console
	 */
	public void playerWin(){
		System.out.println("\nYou win!");
	}
	
	/**
	 * write a "player lost" to console
	 */
	public void playerLose(){
		System.out.println("\nYou lose!");
	}
	
	/**
	 * rolls the dice and prints the results
	 * @return a Roll object storing the result of the roll
	 * @see	Roll
	 */
	public Roll rollDice(){
		Roll roll = new Roll(gameStatus);
		System.out.println(roll.toString());
		return roll;	
	}
	
	/**handles the logic for the come-out (first) roll
	 * @param	the result of the first roll
	 * @see	Roll
	 */
	private void playComeOut(Roll roll){
		switch (roll.getResult()){
			//player got a 7 or 11 and won
			case NATURAL:
				playerWin();
				break;
			
			//player got a 2, 3, and 12 and lost	
			case SNAKE_EYES: // a two
			case ACE_DEUCE: //a 3
			case BOXCARS: //a 12
				System.out.println("Craps!");
				playerLose();
				break;

			//game moves on to the point-phase
			default:	
				gameStatus = GameStatus.POINT;
		}
	}
	
	/** handles the logic for the point phase (all rolls after the 1st)
	 * @param an object representing the point, i.e. the results of the first roll
	 * @see	Roll
	*/
	private void playPoint(Roll point){
		System.out.println();
		System.out.printf("The point is %d\n", point.getValue());

		Roll roll; //stores the info about a roll of two dice

		//keep looping 
		while (true){
			roll = rollDice(); //roll the dice
		
			//if player gets their point, they won
			if (roll.getValue() == point.getValue()){
				playerWin();
				break;
			}
			
			//if they got a 7, they lost
			if (roll.getResult() == Roll.Rolls.SEVEN_OUT){
				playerLose();
				break;
			}
		}
	}
	
	/**plays a round of craps
	* @see Roll */
	public void play(){
		
		//stores the results of the current roll
		Roll roll;
		
		//come out roll
		gameStatus = GameStatus.COME_OUT;
		System.out.println("\nCome Out:");

		try{
			//roll the dice
			roll = rollDice();
		
			//play the 
			playComeOut(roll);
		    		
			//The "point phase"
			if (gameStatus == GameStatus.POINT){
				playPoint(roll);
			}
		}
			
		//this is thrown if there was a problem in the Roll class
		catch (IllegalStateException e){
			System.err.println("IllegalStateException: " + e.getMessage());
			return;
		}
	}
}


