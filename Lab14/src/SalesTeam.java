import java.util.ArrayList;

/**
 * SalesTeam.java
 * This class analyzes the sales data that is passed
 * to it.  The data are an ArrayList of sales slips that indicate
 * how many of each type of product a sales person 
 * sold on a given day and how much money they made on
 * that product.
 * The totals for all product-salesperson combo are
 * stored in a 2D array.
 * The class provides a method for printing a table summary of the data
 * @author Mike
 *
 */
public class SalesTeam {

	private ArrayList<Slip> slipStack; //the sales slips passed to the SalesTeam class
	private int numProds; //the number of products
	private int numSalesPeople;		//the number of sales people

	 //a 2d array storing the quantity totals for product-salesperson combos
	private int [][] quantities;

	//a 2d array storing the dollar amount totals for
	//product-salesperson combos
	private double [][] amounts;
	
	/** The constructor
	 * 
	 * @param slipStack all the sales slips passed to the class
	 * @param numProds the number of products
	 * @param numSalesPeople the number of salespeoples
	 */
	public SalesTeam(ArrayList<Slip> slipStack, int numProds, int numSalesPeople){
		this.slipStack = slipStack;
		this.numProds = numProds;
		this.numSalesPeople = numSalesPeople;
		quantities = new int[numProds][numSalesPeople];
		amounts = new double[numProds][numSalesPeople];

		//go through all the sales slips
		//add the quantity and dollar amount of this sale to the
		//total for this salesperson-product combination
		for (Slip slip : slipStack){
			quantities[slip.getProductID()][slip.getSalesPersonID()] +=
					slip.getQuantity();
			amounts[slip.getProductID()][slip.getSalesPersonID()] += 
					slip.getAmount();
		}
	}
	
	/**
	 * Prints the column headers of the summary table
	 */
	private void displayColumnHeader(){
		//print the salesperson headers
		System.out.format("%12s*", "");
		for (int i = 0; i < numSalesPeople; i++){
			String columnHeader = String.format("Salesperson %d", i + 1);
			System.out.format("%15s *", columnHeader);
		}
		System.out.format("%15s", "Product Total");
		System.out.println();		
	}
	
	/**
	 * Prints the summary table of the data. In the table, shows
	 * how many of each product each salesperson sold.  Also gives total number
	 * of each type of product sold and the total number of products sold by
	 * each salesperson
	 */
	public void displayTotals(){
		int productTotal; //holds the total quantity sold for a product
		int [] salesPersonTotal = new int[numSalesPeople];
		
		System.out.format("%40s%n", "*******************");
		System.out.format("%40s%n", "*SALES TEAM TOTALS*" );
		System.out.format("%40s%n", "*******************");
		System.out.println();

		System.out.format("%40s%n", "QUANTITY TOTALS");
		System.out.println();
		
		//print the column headers
		displayColumnHeader();
		
		printRowBorder();
				
		//Loop over products
		for (int productID = 0; productID < numProds; productID++){
			//print the product header
			String rowHeader = String.format("Product %d", productID + 1);
			System.out.format("%-12s*", rowHeader);
			
			//initialize the running total for this product
			productTotal = 0;
			
			//loop over salespeople
			for (int salesPersonID = 0;
				 salesPersonID < numSalesPeople;
				 salesPersonID++){
	
				//print the quantity for this product/salesperson combo
				printValue(quantities[productID][salesPersonID]);

				//update the running total for this product
				productTotal += quantities[productID][salesPersonID];
			
				//update the running total for this salesperson
				salesPersonTotal[salesPersonID] += quantities[productID][salesPersonID];
			}
			
			//print the total for the product
			System.out.format("   %-12s *", productTotal);

			//move on to next product
			System.out.println();
		}
		
		printRowBorder();
		
		//print the individual salesperson totals
		System.out.format("%12s*", "Seller Total");

		//loop over salespeople
		for (int salesPersonID = 0;
			 salesPersonID < numSalesPeople;
			 salesPersonID++){
			printValue(salesPersonTotal[salesPersonID]);
		}

		//To implement: print table of dollar amounts		
	}

	private static void printValue(double value){
		System.out.format("   %-12.0f *", value);
		
	}
	
	private static void printRowBorder(){
		for (int i = 0; i < 100; i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
}
