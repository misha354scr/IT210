/**
 * A test application for the Invoice class
 * @author Mike
 *
 */

public class InvoiceTest {
	public static void main(String [] args)
	{
		//create an invoice
		Invoice invoice = new Invoice("1234", "Hammer", 2, 14.95);
	
		//print it
		System.out.println("Original Invoice");
		System.out.println(invoice.toString());
		
		System.out.print("\n\n");
		
		//update it and print it again
		System.out.println("Updated invoice information");
		invoice.setPartNo("001234");
		invoice.setDescription("Yellow Hammer");
		invoice.setQuantity(3);
		invoice.setPricePerItem(19.49);
		System.out.println(invoice.toString());

		//test handling of bad input
		System.out.print("\n\n");
		System.out.println("With negative quantity and negative price");
		invoice.setQuantity(-3);
		invoice.setPricePerItem(-19.49);
		System.out.println(invoice.toString());
	}
}
//Original Invoice
//Part number: 1234
//Description: Hammer
//Quantity: 2
//Invoice Amount: 29.90
//
//
//Updated invoice information
//Part number: 001234
//Description: Yellow Hammer
//Quantity: 3
//Invoice Amount: 58.47
//
//
//With negative quantity and negative price
//Part number: 001234
//Description: Yellow Hammer
//Quantity: 0
//Invoice Amount: 0.00