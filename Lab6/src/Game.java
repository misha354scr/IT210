public class Game {

	public enum GameStatus{
		COME_OUT(), POINT();						
	}

	private GameStatus gameStatus;
	
	public void playerWin(){
		System.out.println("\nYou win!");
	}
	
	public void playerLose(){
		System.out.println("\nYou lose!");
	}
	
	public Roll rollDice(){
		Roll roll = new Roll(gameStatus);
		System.out.println(roll.toString());
		return roll;	
	}
	
	private void playComeOut(Roll roll){
		switch (roll.getResult()){
			case NATURAL:
				playerWin();
				break;
			case SNAKE_EYES:
			case ACE_DEUCE:
			case BOXCARS:
				System.out.println("Craps!");
				playerLose();
				break;
			default:	
				gameStatus = GameStatus.POINT;
		}
	}
	
	private void playPoint(Roll point){
		System.out.println();
		System.out.printf("The point is %d\n", point.getValue());

		Roll roll;
		while (true){
			roll = rollDice();
			if (roll.getValue() == point.getValue()){
				playerWin();
				break;
			}
			
			if (roll.getResult() == Roll.Rolls.SEVEN_OUT){
				playerLose();
				break;
			}
		}
	}
	
	public void play(){
		
		Roll roll;
		
		//come out roll
		gameStatus = GameStatus.COME_OUT;
		System.out.println("\nCome Out:");

		try{
			roll = rollDice();
		
			playComeOut(roll);
		    
		
			//The "point phase"
			if (gameStatus == GameStatus.POINT){
				playPoint(roll);
			}
		}
			
		catch (IllegalStateException e){
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
			return;
		}
	}
}


