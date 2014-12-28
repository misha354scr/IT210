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
		invoice.setQuantity(-3);
		invoice.setPricePerItem(-19.49);
		System.out.println(invoice.toString());
	}
}
