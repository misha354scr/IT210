public class Game {

	public enum GameStatus{
		COME_OUT(), POINT();						
	}

	private GameStatus gameStatus;
	
	public void playerWin(){
		System.out.println("You win!");
	}
	
	public void playerLose(){
		System.out.println("You lose!");
	}
	
	
	public Roll rollDice(){
		Roll roll = new Roll(gameStatus);
		System.out.println(roll.toString());
		return roll;	
	}
	
	public void play(){
		
		Roll roll;
		
		//come out roll
		gameStatus = GameStatus.COME_OUT;
		System.out.println("Come Out");

		try{
			roll = rollDice();
		}
		
		catch (IllegalStateException e){
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return;
		}
		    
		if (roll.getResult() == Roll.Rolls.NATURAL){
			playerWin();
		}
		
		if (roll.getResult() == Roll.Rolls.SNAKE_EYES ||
			roll.getResult() == Roll.Rolls.ACE_DEUCE ||
			roll.getResult() == Roll.Rolls.BOXCARS){
				System.out.println("Craps!");
				playerLose();
		}

//		//point phase
//		System.out.println("Point is " + roll.getValue());
//		GameEnums.Rolls point = roll;
//		
//		while (true){
//			roll = RollDice();
//			
//			if (roll == GameEnums.Rolls.SEVEN_OUT){
//				
//			}
//		}
	}
}


