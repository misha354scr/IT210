
public class SalesTeam {

	private int [] employeeSales;	
	
	public SalesTeam(int [] employeeSales){
		this.employeeSales = employeeSales;
	}
	
	/**
	 * Prints the number of employee salaries falling within
	 * specified ranges.  The ranges are
	 * start			 to	increment - 1,
	 * start + increment to start + 2 * increment - 1
	 * ...
	 * greater than    start + increment * (numBins - 1)
	 * @param ranges - an array containing the borders
	 * 		  		   of the salary ranges. Must be an
	 * 				   increasing array of integers
	 */
	public void printSalaryDistribution(int start, int increment, int numBins){

		//holds the count for each of the histogram bins
		int [] histogram = new int[numBins];
		
		int binIndex; //stores the number of the histogram bin
					  //that the salary value being processed belongs to
		
		//Build up the histogram
		
		//Iterate over employees
		for (int sales : employeeSales){
			//calculate the bin
			int salary = 200 + (int)(sales * 0.09);
			binIndex = (salary - start) / increment;
			
			//If the number falls in the last bin, make sure
			//to avoid array overrun
			if (binIndex >= numBins - 1){
				binIndex = numBins - 1;
			}
			
			//incorrect the counter for the histogram bin that sales for this
			//employee are in
			histogram[binIndex]++;
		} //end loop over employees
		
		//Print the column headings
		System.out.format("%-20s%s%n", "Salary Range", "Number of Employees");

		String heading; //holds the heading for the current table row
		
		//Iterate over the bins
		for (int i = 0; i < numBins; i++){
			//Print this bin's range
			
			//Print the range for the last bin
			if (i == numBins - 1){
				heading = String.format("Greater than $%d:",
											   start + increment * i);
			}
			//Print the range for all previous bins
			else{
				heading = String.format("$%d - $%d:", start, 
											 start + increment * i);
			}

			System.out.format("%-20s", heading); //print the heading
			
			//print the bin count for this bin
			System.out.format("%d", histogram[i]);
			System.out.println();
		}
	}
	
}
//Salary Range        Number of Employees
//$200 - $200:        3
//$200 - $300:        5
//$200 - $400:        20
//$200 - $500:        22
//$200 - $600:        5
//$200 - $700:        0
//$200 - $800:        0
//$200 - $900:        0
//Greater than $1000: 0