import java.util.Scanner;
class GameTester
 {
	 public static void main(String[] args)
     {
		 System.out.println("Would you like to play the guessing game [y/n]? ");
         Scanner input = new Scanner(System.in);
         char cResponse = input.next().toUpperCase().charAt(0);

         while (cResponse == 'Y')
         {
            Game g = new Game();
            System.out.printf("Guess a number between {0} and {1}, -1 to Exit", Game.LOW, Game.HI);
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
                  Console.Write("Enter you guess: ");
                  g.UsersGuess = Convert.ToInt32(Console.ReadLine());
               }
            }
            Console.Write("Would you like to play again [Y or N]? ");
            cResponse = Console.ReadLine().ToUpper()[0];
         }
      }
   }
}
