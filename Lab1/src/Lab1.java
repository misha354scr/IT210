import java.util.Scanner;

/**
 * IT-210 Lab 1
 * @author Mike
 * declares and initializes variables of 10
 * different datatypes and prints them.
 * Then prompts the user for a value of each
 * variable and prints it.
 *
 */
public class Lab1 {

	public static void main (String [] args)
	{
		byte b = 'P';
		short s = 16;
		int i = 10;
		long l = 64;
		float f = 88133.125000F;
		double d = 3377.123456789012400;
		char c = 'X';
		String str = "myString";
		boolean bool = true;
		Object o = "myObject";
		
		//First part
		System.out.println("**** Part1: ****");
		System.out.printf("Byte = %c\n", b);
		System.out.println("Short = " + s);
		System.out.println("Int = " + i);
		System.out.println("Long = " + l);
		System.out.printf("Float = %.6f\n", f);
		System.out.printf("Double = %.15f\n", d);
		System.out.println("Char =  " + c);
		System.out.println("String = " + str);
		System.out.printf("Boolean = %B\n", bool);
		System.out.println("Object = " + o);
		
		System.out.println();
		System.out.println("**** Part1: ****");

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a byte: ");
		b = scan.nextByte();
		System.out.printf("Byte = %c\n", b);

		System.out.print("Enter an Int: ");
		i = scan.nextInt();
		System.out.printf("Int = %d\n", i);
		
		System.out.print("Enter an Int16: ");
		s = scan.nextShort();
		System.out.printf("Int16 = %d\n", s);

		System.out.print("Enter an Long Int: ");
		l = scan.nextLong();
		System.out.printf("Long Int = %d\n", l);
				
		System.out.print("Enter a  Float: ");
		f = scan.nextFloat();
		System.out.printf("Float = %13.6f\n", f);
		
		System.out.print("Enter a Double: ");
		d = scan.nextDouble();
		System.out.printf("Int = %1.6e\n", d);
		
		System.out.print("Enter a String: ");
		str = scan.next();
		System.out.println("First char = " + str.charAt(0));

		System.out.print("Enter a String: ");
		str = scan.next();
		System.out.println("String = " + str);

		System.out.print("Enter a Boolean (true/false): ");
		bool = scan.nextBoolean();
		System.out.printf("Boolean (uppercase) = %B\n", bool);
		
		System.out.print("Enter a string: ");
		o = scan.next();
		System.out.println("Object = " +  o);
		
		System.out.println("Done...");
	}
}

//**** Part1: ****
//Byte = P
//Short = 16
//Int = 10
//Long = 64
//Float = 88133.125000
//Double = 3377.123456789012400
//Char =  X
//String = myString
//Boolean = TRUE
//Object = myObject
//
//**** Part1: ****
//Enter a byte: 86
//Byte = V
//Enter an Int: 4455
//Int = 4455
//Enter an Int16: 32
//Int16 = 32
//Enter an Long Int: 999999
//Long Int = 999999
//Enter a  Float: 1234567.123456789
//Float = 1234567.125000
//Enter a Double: 1234567.123456789
//Int = 1.234567e+06
//Enter a String: Saleem
//First char = S
//Enter a String: Yusuf
//String = Yusuf
//Enter a Boolean (true/false): true
//Boolean (uppercase) = TRUE
//Enter a string: Michael
//Object = Michael
//Done...
