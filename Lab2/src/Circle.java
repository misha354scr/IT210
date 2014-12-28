import java.util.Scanner;

/** 
 * Circle.java

 * A program that prompts the user for the radius of a circle
 * and calculates the circumference, area, and diameter
 */
public class Circle {
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		int radius = input.nextInt();
		
		System.out.format("Diameter: %d\n", 2 * radius);
		System.out.format("Circumference: %.2f\n", 2 * Math.PI * radius);
		System.out.format("Area: %.2f", Math.PI * radius * radius);
		input.close();
	}
}

//Enter the radius: 8
//Diameter: 16
//Circumference: 50.27
//Area: 201.06