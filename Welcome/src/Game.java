import java.util.Random;


public class Game {

	public void play(){
		int dice = RollDice();
		
	}
	
	GameEnums.Rolls RollDice(){
		Random randomGenerator = new Random();
		int number1, number2;

		number1 = randomGenerator.nextInt(5) + 1;
		number2 = randomGenerator.nextInt(5) + 1;

		System.out.println("You rolled a " + number1 + " and a " + number2 +
				 			" for a total of " + (number1 + number2));
		
		GameEnums.Rolls result;
		
		switch (number1){
			case 1:
				switch (number2){
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
				}
				break;
				
			case 2:
				switch (number2){
				case 1:
					result = GameEnums.Rolls.ACE_DEUCE;
					break;
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
					result = GameEnums.Rolls.SEVEN_OUT;
					break;
				}
				break;
		}

		return number1 + number2;
	}
}
