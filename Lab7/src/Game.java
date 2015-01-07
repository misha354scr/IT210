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
	 
	 //constructor
	 public Game()
	 {
		 numTries = 0;
	     usersGuess = NOT_SET;
	     suggestedGuess = HI/2;
	     rand = new Random();
	     secretNum = rand.nextInt(HI) + 1;
	  }

	  //public methods
	  //Checks user guess against secret number.
	  //If the the guess is wrong, prints a hint
	  //If the guess is right, displays the win/loss message
	  public void CheckResults()
	  {
		  updateNumTries(); //update the try counter

	      if (usersGuess < secretNum)
	         {
	            System.out.println("Too low. Try again. ");
	         }
	         else if (usersGuess > secretNum)
	         {
	            System.out.println("Too high. Try again. ");
	         }
	         else
	         {
	            guessed = true;
	            DisplayResults();
	         }
	      

	      }

	  public 
	  
	      public void DisplayResults()
	      {
	         if (NumTries <= 10)
	            Console.WriteLine("Aha! You know the secret!");
	         else
	         {
	            Console.WriteLine("You should be able to do better!");
	         }
	      }
	   
	  private void updateNumTries(){
		  numTries++;
	  }
	  
	  public void setUsersGuess(int guess){
		  usersGuess = guess;
	  }

	  public int getUsersGuess(){
		  return guess;
	  }
	  
	  private int suggestGuess(){
		  
	  }

}
