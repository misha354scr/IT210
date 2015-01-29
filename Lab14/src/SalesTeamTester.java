import java.util.ArrayList;


public class SalesTeamTester {

	public static void main(String [] args){
			
		//The sales force data. In this 3D array,
		//each 2D array corresponds to a day.
		//The 2D array represents a spreadsheet
		//of form
		//         Salesperson 1 2 3 4
		//Product1             x x x x 
		//Product2             x x x x etc.
		//where the x's are the number of units sold
		//The test data were generated using a normal distribution
		//in Excel file TestCases.xlsx
		//the mean and standard deviation for each salesperson
		//are different
		int [][][] salesData = {
					   {{18,9,	34,	7}, //day1
					   	{14,6,	3,	9},
					   	{6,	4,	13,	9},
					   	{9,	3,	2,	7},
					   	{3,	1,	0,	1}}, 
					   	
					   	{{23,8,	60,	16}, //day 2
					   	{19, 6,	47,	9},
					   	{11, 4,	2,	11}, 
					   	{7,	3,	15,	5},
					   	{2,	1,	2,	1}},
					   	
					   	{{23,8,	31,	9}, //day 3
					   	{12,6,	38,	12},
					   	{12,4,	34,	9},
					   	{8,	3,	2,	6},
					   	{2,	1,	6,	2}},
					   	
					   	{{14,8,	28,	15}, //day 4
					   	{14,6,	42,	13},
					   	{10,4,	23,	8},
					   	{14,3,	0,	3},
					   	{3, 1,	9,	2}},
					   	
					   	{{24,	9,	23,	11},
					   	 {14,	6,	18,	12},
					   	 {5,	4,	15,	7},
					   	 {5,	3,	18,	6},
					   	 {2,	1,	0,	2}}
					};

		int numProds = salesData[0].length;
		int numSalesPersons = salesData[0][0].length;
		
		//the price in dollars for one unit of each product
		double [] prices = {10, 13, 18, 25, 60};

		//holds all the sales slips
		ArrayList<Slip> slipStack = new ArrayList<Slip>();
		
		//Generate the sales slips
		
		//loop over days
		for (int [][] day : salesData){
			//loop over products
			for (int productID = 0; productID < day.length; productID++){
				int [] product = day[productID];
			
				//loop over salespeople
				for (int salesPersonID = 0; 
					 salesPersonID < product.length;
					 salesPersonID++){
						int quantity = product[salesPersonID];
						Slip slip = new Slip(productID,
											salesPersonID,
									        product[salesPersonID],
									        quantity);
						slipStack.add(slip);
				}
			}
		}
		SalesTeam team = new SalesTeam(slipStack, numProds, numSalesPersons);
		team.displayTotals();
	}	
}

//*  Salesperson 1 *  Salesperson 2 *  Salesperson 3 *  Salesperson 4 *  Product Total
//****************************************************************************************************
//Product 1   *   102          *   42           *   176          *   58           *   378          *
//Product 2   *   73           *   30           *   148          *   55           *   306          *
//Product 3   *   44           *   20           *   87           *   44           *   195          *
//Product 4   *   43           *   15           *   37           *   27           *   122          *
//Product 5   *   12           *   5            *   17           *   8            *   42           *
//****************************************************************************************************
//Seller Total*   274          *   112          *   465          *   192          *