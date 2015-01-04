import java.util.Random;

public class Roll {

	Game.GameStatus gameStatus;

	
	public Roll(Game.GameStatus gameStatus){
		this.gameStatus = gameStatus;
		Random randomGenerator = new Random();
		int number1, number2;
	
		//the values of the two die rolls
		number1 = randomGenerator.nextInt(5) + 1;
		number2 = randomGenerator.nextInt(5) + 1;
	
		//holds the lower of the two die values
		int lowerDie = Math.min(number1, number2); 
	
		//holds the lower of the two die values
		int higherDie = Math.max(number1, number2);

	
	}

	
	
}
