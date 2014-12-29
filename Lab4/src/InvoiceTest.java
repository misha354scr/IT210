public class InvoiceTest {
	public static void main(String [] args)
	{
		Invoice invoice = new Invoice("1234", "Hammer", 2, 14.95);
	
		System.out.println("Original Invoice");
		System.out.println(invoice.toString());
		
		System.out.print("\n\n");
		
		System.out.println("Updated invoice information");
		invoice.setPartNo("001234");
		invoice.setDescription("Yellow Hammer");
		invoice.setQuantity(3);
		invoice.setPricePerItem(19.49);
		System.out.println(invoice.toString());

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