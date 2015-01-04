import java.util.Random;

public class Roll {
	
	public enum Rolls{
		SNAKE_EYES(2),	//two ones
		ACE_DEUCE(3),	// a 1 and a 2
		EASY_FOUR(4),	// a 1 and a 3
		HARD_FOUR(4),	//two 2
		FIVE(5),		//any 5 		
		EASY_SIX(6), 	//1 and 5 OR 2 and 4
		HARD_SIX(6),
		SEVEN_OUT(7), NATURAL(7),
		EASY_EIGHT(8),
		HARD_EIGHT(8), NINE(9), EASY_TEN(10), HARD_TEN(10), YO_LEVEN(11),
		BOXCARS(12);		 
		
		private int value;
		
		private Rolls(int value){
			this.value = value;
		}
	
		public int getValue(){
			return this.value;
		}		
	}
	
	Game.GameStatus gameStatus;
	private Rolls result;

	public Rolls getResult(){
		return result;
	}
	
	public void printResult(){
		
	}
	
	private Rolls NaturalOrSevenOut(Game.GameStatus gameStatus){
		if (gameStatus == Game.GameStatus.COME_OUT)
			return Rolls.NATURAL;
		else
			return Rolls.SEVEN_OUT;
	}
	
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
		
		System.out.println("You rolled a " + number1 + " and a " + number2 +
	 			" for a total of " + (number1 + number2));

		
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
					result = NaturalOrSevenOut(gameStatus);
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
					result = NaturalOrSevenOut(gameStatus);
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
					result = NaturalOrSevenOut(gameStatus);
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
					result = Rolls.YO_LEVEN;
					break;
			}
		}
		
		//both dices are sixes
		else{
			result = Rolls.BOXCARS;
		}	
	}
}
