import java.util.Scanner;
class GameTester
 {
	 public static void main(String[] args)
     {
		 System.out.println("Would you like to play the guessing game [y/n]? ");
         Scanner input = new Scanner(System.in);
         char cResponse = input.next().toUpperCase().charAt(0);

         int usersGuess;
         
         while (cResponse == 'Y')
         {
            Game g = new Game();
            System.out.printf("Try %d: Guess a number between %d and %d (I suggest %d), -1 to Exit\n",
            		g.getNumTries(), Game.LOW, Game.HI, g.getSuggestedGuess());
            
            System.out.print("Enter you guess: ");
            g.setUsersGuess(input.nextInt());
            if (g.getUsersGuess() == -1)
            {
               System.out.println("Good bye...");
               break;
            }

            while (!g.guessed)
            {
               if (g.getUsersGuess() == -1)
               {
                  System.out.println("Good bye...");
                  return;
               }

               g.CheckResults();
               if (!g.guessed)
               {
                  while (true){
                      System.out.printf("Try %d: Enter your guess (I suggest %d): ",
                    		  g.getNumTries(), g.getSuggestedGuess());
                	  try{
                		  usersGuess = input.nextInt();
                		  break;
                	  }
                	  catch(Exception ex){
                		  System.out.println("Invalid input");
                	  }
                  }
                  
                  g.setUsersGuess(usersGuess);
               }
            }
            System.out.println("Would you like to play again [Y or N]? ");
            cResponse = input.nextLine().toUpperCase().charAt(0);
         }
      }
}
