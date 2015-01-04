import java.util.Random;


public class Game {

	public enum GameStatus{
		COME_OUT(), POINT();						
	}

	
	public void playerWin(){
		System.out.println("You win!");
	}
	
	public void playerLose(){
		System.out.println("You lose!");
	}
	
	private GameEnums.Rolls NaturalOrSevenOut(GameEnums.GameStatus gameStatus){
		if (gameStatus == GameEnums.GameStatus.COME_OUT)
			return GameEnums.Rolls.NATURAL;
		else
			return GameEnums.Rolls.SEVEN_OUT;
	}
	
	public void play(){
		
		
		//come out roll
		System.out.println("Come Out");
		GameEnums.Rolls roll = RollDice();
				
		if (roll == GameEnums.Rolls.SEVEN_OUT || 
			roll == GameEnums.Rolls.YO_LEVEN){
			System.out.println("Natural!");
			playerWin();
		}
		
		if (roll == GameEnums.Rolls.SNAKE_EYES ||
			roll == GameEnums.Rolls.ACE_DEUCE ||
			roll == GameEnums.Rolls.BOXCARS){
				System.out.println("Craps!");
				playerLose();
		}

		//point phase
		System.out.println("Point is " + roll.getValue());
		GameEnums.Rolls point = roll;
		
		while (true){
			roll = RollDice();
			
			if (roll == GameEnums.Rolls.SEVEN_OUT){
				
			}
		}
	}
		
	GameEnums.Rolls RollDice(GameEnums.GameStatus gameStatus){
		Random randomGenerator = new Random();
		int number1, number2;
	
		//the values of the two die rolls
		number1 = randomGenerator.nextInt(5) + 1;
		number2 = randomGenerator.nextInt(5) + 1;
	
		//holds the lower of the two die values
		int lowerDie = Math.min(number1, number2); 
	
		//holds the lower of the two die values
		int higherDie = Math.max(number1, number2);
			
		System.out.println("You rolled a " + number1 + " and a " + number2 +
					 			" for a total of " + (number1 + number2));
					
		//Decide the name of the roll
		GameEnums.Rolls result;
	
		if (lowerDie == 1){
							
			switch (higherDie){
				case 1:
					result = GameEnums.Rolls.SNAKE_EYES;
					break;
				case 2:
					result = GameEnums.Rolls.ACE_DEUCE;
					break;
				case 3:
					result = GameEnums.Rolls.EASY_FOUR;
					break;
				case 4:
					result = GameEnums.Rolls.FIVE;
					break;
				case 5:
					result = GameEnums.Rolls.EASY_SIX;
					break;
				case 6:
					result = NaturalOrSevenOut(gameStatus);
					break;
				}
			}
	
		else if (lowerDie == 2){
			switch(higherDie){
				case 2:
					result = GameEnums.Rolls.HARD_FOUR;
					break;
				case 3:
					result = GameEnums.Rolls.FIVE;
					break;
				case 4:
					result = GameEnums.Rolls.EASY_SIX;
					break;
				case 5:
					result = NaturalOrSevenOut(gameStatus);
					break;
				case 6:
					result = GameEnums.Rolls.EASY_EIGHT;
					break;
			}
		}
			
		else if (lowerDie == 3){
			switch (higherDie){
				case 3:
					result = GameEnums.Rolls.HARD_SIX;
					break;
				case 4:
					result = NaturalOrSevenOut(gameStatus);
					break;
				case 5:
					result = GameEnums.Rolls.EASY_EIGHT;
					break;
				case 6:
					result = GameEnums.Rolls.NINE;
					break;
			}
		}
				
		else if (lowerDie == 4){
			switch (higherDie){
				case 4:
					result = GameEnums.Rolls.HARD_EIGHT;
					break;
				case 5:
					result = GameEnums.Rolls.NINE;
					break;
				case 6:
					result = GameEnums.Rolls.EASY_TEN;
					break;
			}
		}
			
		else if (lowerDie == 5){
			switch(higherDie){
				case 5:
					result = GameEnums.Rolls.HARD_TEN;
					break;
				case 6:
					result = GameEnums.Rolls.YO_LEVEN;
					break;
			}
		}
		
		//both dices are sixes
		else{
			result = GameEnums.Rolls.BOXCARS;
			break;
		}
		
		System.out.println(result.name());
		return result;
		}
	}


}


