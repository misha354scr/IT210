import java.util.Scanner;

/** 
 * Digits.java

 * A program that prompts the user for a five digit number
 * and then parses out the digits
 */
public class Digits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Ask user to enter a 5 digit number.
		 * Calculate and determine all the digits
		 * Display the result
		 */
		
		/*
		 * DECLARATIONS
		 */
		final int DECIMAL = 10;		// We are using decimal numbering system
		int digit1; // first digit
		int digit2; // second digit
		int digit3; // third digit
		int digit4; // fourth digit
		int digit5; // fifth digit
		Scanner input = new Scanner (System.in);
		
		/*
		 * INPUT
		 */
		System.out.format("Enter a number: ");
		int number = input.nextInt();

		/*
		 * CALCULATIONS
		 */

		/* write code here that will separate the remainder of the digits in the
		variable "number" and assign each one to the corresponding integer
		variable */
		digit1 = number / 10000;
		digit2 = number % 10000 / 1000;
		digit3 = number % 1000 / 100;
		digit4 = number % 100 / 10;
		digit5 = number % 10;

		/*
		 * OUTPUT
		 */


		/* write a statement that displays each digit separated by three spaces. */
		System.out.format("Digits in %d %d %d %d %d %d", number, digit1, digit2, digit3, digit4, digit5);
	}
} // end main
