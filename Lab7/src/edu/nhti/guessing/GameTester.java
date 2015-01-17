package edu.nhti.guessing;
import java.util.Scanner;

/**
 * The driver class for the guessing game
 * Game class
 */
class GameTester
 {
	//the instance of Game being played
	private static Game g;
	
	/**
	 * Prompts the user for a number in the current Game's
	 * range
	 * @return the user's input
	 */
	private static int readUsersGuess(){
		int usersGuess;		
        Scanner input = new Scanner(System.in);
		
		while (true){
		//Loop until the user enters valid input
			System.out.printf("Try %d: Guess a number between %d and %d " + 
							   "(I suggest %d), -1 to Exit%n" + 
							   "It should take %d tries%n",
							   g.getNumTries(), Game.LOW, Game.HI, g.suggestGuess(),
							   g.getWinningNumTries());
			try{
				System.out.print("Enter you guess: ");
				usersGuess = input.nextInt();
				break;
			}
			catch(Exception ex){
				System.out.println("Invalid input.");
  	  		}
		}
        return usersGuess;
	}
	
	/**
	 * the main application method
	 * @param args
	 */
	 public static void main(String[] args)
     {
		 System.out.println("Would you like to play the guessing game [y/n]? ");
         Scanner input = new Scanner(System.in);
         char cResponse = input.next().toUpperCase().charAt(0);

         int usersGuess;
         
         //play a round
         while (cResponse == 'Y')
         {
          
        	//Get the first guess
            g = new Game();
            usersGuess = readUsersGuess();

            //if sentinel value detected quit,
            //otherwise set the game's userGuess variable
            if (usersGuess == -1)
            {
               System.out.println("Good bye...");
               break;
            }
            else{
            	g.setUsersGuess(usersGuess);
            }

            //check the results of the first guess
            g.CheckResults();
            System.out.println();
            
            //if first guess is incorrect, prompt for another guess
            //and check it
            //Repeat until the user guesses correctly
            while (!g.guessed())
            {           
                usersGuess = readUsersGuess(); //read the guess
                
                //if sentinel value detected quit,
                //otherwise set the game's userGuess variable
            	if (usersGuess == -1)
                {
                   System.out.println("Good bye...");
                   break;
                }
                else{
                	g.setUsersGuess(usersGuess);
                }
            
            	g.CheckResults();
            	System.out.println();
            }
            
            System.out.print("Would you like to play again [Y or N]? ");
            cResponse = input.next().toUpperCase().charAt(0);
         }
      }
}

//Would you like to play the guessing game [y/n]? 
//y
//Try 1: Guess a number between 1 and 1000 (I suggest 500), -1 to Exit
//Enter you guess: 500
//Too low. Try again. 
//Try 2: Guess a number between 1 and 1000 (I suggest 750), -1 to Exit
//Enter you guess: 750
//Too high. Try again. 
//Try 3: Guess a number between 1 and 1000 (I suggest 625), -1 to Exit
//Enter you guess: 625
//Too low. Try again. 
//Try 4: Guess a number between 1 and 1000 (I suggest 687), -1 to Exit
//Enter you guess: 687
//Too low. Try again. 
//Try 5: Guess a number between 1 and 1000 (I suggest 718), -1 to Exit
//Enter you guess: 718
//Too low. Try again. 
//Try 6: Guess a number between 1 and 1000 (I suggest 734), -1 to Exit
//Enter you guess: 734
//Too low. Try again. 
//Try 7: Guess a number between 1 and 1000 (I suggest 742), -1 to Exit
//Enter you guess: 742
//Aha! You know the secret!
//Would you like to play again [Y or N]? n
