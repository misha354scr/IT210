/** 
 * GameEnums.java

 * Defines a class of containing an enum whose values correspond
 * to the possible outcomes of a roll of two dice.  The names of the
 * outcomes are from the Craps terminology
 */
public class GameEnums {

	public enum Rolls{
		SNAKE_EYES(2),	//two ones
		ACE_DEUCE(3),	// a 1 and a 2
		EASY_FOUR(4),	// a 1 and a 3
		HARD_FOUR(4),	//two 2
		FIVE(5),		//any 5 		
		EASY_SIX(6), 	//1 and 5 OR 2 and 4
		HARD_SIX(6), SEVEN_OUT(7), EASY_EIGHT(8),
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
}
