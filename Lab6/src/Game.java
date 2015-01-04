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
					
		
		System.out.println(result.name());
		return result;
		}
	}


}


