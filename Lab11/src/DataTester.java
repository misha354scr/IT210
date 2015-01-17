/**
 * Test cases for the IntegerData class
 * @author Mike
 *
 */
public class DataTester {

	public static void main(String [] args){
		int[] arr = new int[100];
		arr[0] = 77; 			// insert 10 items
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 3;
		arr[8] = 66;
		arr[9] = 33;
		int nElems = 10; 			// now 10 items in array
	
		IntegerData arrayObj= new IntegerData(arr, nElems);
		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();
	
		System.out.println();
		
		System.out.format("\nDisplaying element at index 6 of the array\n");
		arrayObj.DisplayAt(6);
	
		System.out.format("\nFind 55 in the array\n");
		if (arrayObj.Find(55) != -1) {
			System.out.format("Number 55 was found at index %d of the array\n", arrayObj.Find(55));
		}
		else {
			System.out.format("Number 55 was NOT found.\n");
		}
		
		System.out.format("\nDelete 55 from the array\n");
		arrayObj.Delete(55);
			
		System.out.format("\nFind 55 in the array\n");
		if (arrayObj.Find(55) != -1) {
			System.out.format("Number 55 was found at index %d of the array\n", arrayObj.Find(55));
		}
		else {
			System.out.format("Number 55 was NOT found.\n");
		}

		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();
	
		System.out.println();
		
		System.out.format("\nSorting the array\n");
		arrayObj.bubbleSort();
		
		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();
		
		System.out.println();
		
		System.out.format("\nInset 49 into the array and then display array\n");
		arrayObj.insert(49);

		arrayObj.DisplayAll();

	}
}


//Displaying all members of the array
//77 99 44 55 22 88 11 3 66 33 
//
//Displaying element at index 6 of the array
//Value at index 6 is: 11
//
//Find 55 in the array
//Number 55 was found at index 3 of the array
//
//Delete 55 from the array
//
//Find 55 in the array
//Number 55 was NOT found.
//
//Displaying all members of the array
//77 99 44 22 88 11 3 66 33 
//
//Sorting the array
//
//Displaying all members of the array
//3 11 22 33 44 66 77 88 99 
//
//Inset 49 into the array and then display array
//3 11 22 33 44 66 77 88 99 49 
