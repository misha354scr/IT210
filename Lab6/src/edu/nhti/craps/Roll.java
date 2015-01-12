package edu.nhti.craps;

import java.util.Random;

public class Roll {

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

		private String name;
		
		private Rolls(String name){
			this.name = name;
		}
				
		public String toString(){
			return name;
		}
	}
	
	private int number1, number2;
	private Game.GameStatus gameStatus;
	private Rolls result;

	public Rolls getResult(){
		return result;
	}
	
	public int getValue(){
		return number1 + number2;
	}
	
	public String toString(){
		return String.format("You rolled a %d and a %d, for a total of %d. "
				+ "That's a(n) %s.", number1, number2, number1 + number2, result.toString());		
	}
	
	private Rolls NaturalOrYoLeven() throws IllegalStateException{
		
		if (number1 + number2 != 11)
			throw new IllegalStateException("Natural 11 declared on roll" +
		"that's not an 11");
		
		if (gameStatus == Game.GameStatus.COME_OUT)
			return Rolls.NATURAL;
		else
			return Rolls.YO_LEVEN;
	}

	private Rolls NaturalOrSevenOut(){

		if (number1 + number2 != 7)
			throw new IllegalStateException("Natural 7 declared on roll" +
		"that's not a 7");

		if (gameStatus == Game.GameStatus.COME_OUT)
			return Rolls.NATURAL;
		else
			return Rolls.SEVEN_OUT;
	}
	
	public Roll(Game.GameStatus gameStatus){
		this.gameStatus = gameStatus;
		Random randomGenerator = new Random();
	
		//the values of the two die rolls
		number1 = randomGenerator.nextInt(5) + 1;
		number2 = randomGenerator.nextInt(5) + 1;
	
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
