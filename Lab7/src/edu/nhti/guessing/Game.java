package edu.nhti.guessing;

import java.util.Random;

public class Game
{
	//the low and high numbers for the guess range
	public final static int LOW = 1;
	public final static int HI = 2000;

	//fields

	//the random numbers generator
	private static Random rand;
	//the number of times the user has tried to guess
	private int numTries; 

	//the secret number the user is trying to guess
	private int secretNum;

	//the current guess
	private int usersGuess;

	 //these are used to suggest a guess
	 private int lastGuess; 	 //the user's last guess
	 private int lastTooLow; //last user's guess that was too low
	 private int lastTooHigh; //last user's guess that was too high
	 
	 /**constructor
	  */
	 public Game()
	 {
		 numTries = 1;
	     rand = new Random();
	     secretNum = rand.nextInt(HI) + 1;

	     //these are chosen
	     //so the first call to suggestGuess() works correctly
	     lastGuess = 0;
	     usersGuess = 0;
	     lastTooLow = Game.LOW;
	     lastTooHigh = Game.HI;
	 }

	  //public methods

	 /**
	  * Returns true if the user's guess is equal to the secret number
	  * @return true if the user's guess is equal to the secret number
	  */
	 public boolean guessed(){
		 return usersGuess == secretNum;
	 }
	 
	 /**Checks user guess against secret number.
	  * If the the guess is wrong, prints a hint
	  If the guess is right, displays the win/loss message
	  */	 
	 public void CheckResults()
	 {
		 if (usersGuess == secretNum){
		 //user guessed correctly
			 DisplayResults();
	      }
	      
	      else{
	      //user guessed wrong	  
	    	  if (usersGuess > secretNum){
              //user's guess it too high
	    		  System.out.println("Too high. Try again. ");
	    	  }	    	  
	    	  else{
	    	  //user's guess is too low	  
		            System.out.println("Too low. Try again. ");	    		  
	    	  }
	    	  
	    	  //this guess will be the "last guess" on the next call to
	    	  //suggestGuess()
	    	  lastGuess = usersGuess;
	    	  
	    	  updateNumTries(); //update the try counter
	      }
	  }	    	  
	 
	 public int getWinningNumTries(){
		 return (int) Math.ceil(Math.log(HI - LOW) / Math.log(2));
	 }
	 
	 //Private methods
	 
	 /**
	  * Called at the end of the game
	  * If the number of guesses is greater than
	  * 
	  */
	 private void DisplayResults()
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
	  public int suggestGuess(){
		  //user guessed too high this time
//		  System.out.printf("Last guess: %d\n", lastGuess);
		  int suggestion;

		  if (usersGuess > secretNum){
			  
			  //suggest point halfway between last "too low guess" and this guess
			  suggestion =  lastTooLow + (usersGuess - lastTooLow)/2;
			  lastTooHigh = usersGuess;
		  }			  

		  //user guessed too low this time
		  //suggest point halfway between this guess and the last "too high" guess
		  else{
			  suggestion = usersGuess + (lastTooHigh - usersGuess)/2;
			  lastTooLow = usersGuess;
		  }
		  return suggestion;
	  }
	  	  
	  public int getNumTries(){
		  return numTries;
	  }
}
