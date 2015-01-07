import java.util.Random;

public class Game
{
	public final static int LOW = 1;
	public final static int HI = 1000;
	private final int NOT_SET = HI + 1;

	//fields
	private static Random rand;

	//public properties
	 public boolean guessed;
	 
	 public int numTries; 
	 private int secretNum;
	 private int usersGuess;
	 private int suggestedGuess;     
	 private int lastGuess;
	 private int lastTooLow;
	 private int lastTooHigh;
	 
	 //constructor
	 public Game()
	 {
		 numTries = 1;
	     usersGuess = NOT_SET;
	     suggestedGuess = HI/2;
	     rand = new Random();
	     secretNum = rand.nextInt(HI) + 1;
	     lastGuess = 0;
	 }

	  //public methods
	  //Checks user guess against secret number.
	  //If the the guess is wrong, prints a hint
	  //If the guess is right, displays the win/loss message
	  public void CheckResults()
	  {
		  
	      if (usersGuess == secretNum){
	    	  guessed = true;
	    	  DisplayResults();
	      }
	      
	      else{
	    	  if (usersGuess > secretNum){
		            System.out.println("Too high. Try again. ");
	    	  }
	    	  
	    	  else{
		            System.out.println("Too low. Try again. ");	    		  
	    	  }
	    	  
	    	  suggestedGuess = suggestGuess();
	    	  lastGuess = usersGuess;
	    	  updateNumTries(); //update the try counter

	      }
	  }	    	  
	  
	      public void DisplayResults()
	      {
	         if (numTries <= 10)
	            System.out.println("Aha! You know the secret!");
	         else
	         {
	            System.out.println("You should be able to do better!");
	         }
	      }
	   
	  private void updateNumTries(){
		  numTries++;
	  }
	  
	  public void setUsersGuess(int guess){
		  usersGuess = guess;
	  }

	  public int getUsersGuess(){
		  return usersGuess;
	  }
	  
	  /**
	   * Suggests a new guess:
	   * The new guess is halfway between the last guess and this guess
	   * if the last guess is in the direction of the secret number.
	   * Otherwise, it's halfway between this guess and the end of the range
	   * @return
	   */
	  private int suggestGuess(){
		  //user guessed too high this time
		  System.out.printf("Last guess: %d\n", lastGuess);
		  if (usersGuess > secretNum){
			  
			  //the last guess is greater or equal to this one
			  if (lastGuess >= usersGuess){
				  //halve the current guess and suggest it as the next guess
				  return usersGuess / 2;
			  }
			  
			  //the last guess is lower than this one
			  else{
				  //suggest halfway point btw the last guess and this guess
				  //as new guess
				  return lastGuess + (usersGuess - lastGuess) / 2;
			  }
		  }
		  
		  //user guessed too low
		  else{
			  //the last guess is in the wrong direction (lower than this one)
			  if (lastGuess <= usersGuess){
				  return usersGuess + (Game.HI - usersGuess) / 2;
			  }

			  //
			  else{
				  return usersGuess + (lastGuess - usersGuess)/2;
			  }
		  }
	  }
	  
	  public int getSuggestedGuess(){
		  return suggestedGuess;
	  }
	  
	  public int getNumTries(){
		  return numTries;
	  }
}
