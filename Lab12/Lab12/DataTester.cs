using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
   public class DataTester
   {

      public static void Main(String[] args){
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
		   Console.WriteLine("\nDisplaying all members of the array\n");
		   arrayObj.DisplayAll();
	
		   Console.WriteLine();
		
		   Console.WriteLine("\nDisplaying element at index 6 of the array\n");
		   arrayObj.DisplayAt(6);
	
		   Console.WriteLine("\nFind 55 in the array\n");
		   if (arrayObj.Find(55) != -1) {
			   Console.WriteLine("Number 55 was found at index {0} of the array\n", arrayObj.Find(55));
		   }
		   else {
			   Console.WriteLine("Number 55 was NOT found.\n");
		   }
		
		   Console.WriteLine("\nDelete 55 from the array\n");
		   arrayObj.Delete(55);
			
		   Console.WriteLine("\nFind 55 in the array\n");
		   if (arrayObj.Find(55) != -1) {
			   Console.WriteLine("Number 55 was found at index {0} of the array\n", arrayObj.Find(55));
		   }
		   else {
			   Console.WriteLine("Number 55 was NOT found.\n");
		   }

		   Console.WriteLine("\nDisplaying all members of the array\n");
		   arrayObj.DisplayAll();
	
         Console.WriteLine();		
		   Console.WriteLine("\nSorting the array\n");
		   arrayObj.bubbleSort();
		
		   Console.WriteLine("\nDisplaying all members of the array\n");
		   arrayObj.DisplayAll();
		
		   Console.WriteLine();
		
		   Console.WriteLine("\nInset 49 into the array and then display array\n");
		   arrayObj.insert(49);

		   arrayObj.DisplayAll();
         Console.WriteLine();
	   }
   }
}

//Displaying all members of the array

//77 99 44 55 22 88 11 3 66 33

//Displaying element at index 6 of the array

//Value at index 6 is: 11

//Find 55 in the array

//Number 55 was found at index 3 of the array


//Delete 55 from the array


//Find 55 in the array

//Number 55 was NOT found.


//Displaying all members of the array

//77 99 44 22 88 11 3 66 33

//Sorting the array


//Displaying all members of the array

//11 22 3 66 88 44 33 99 77

//Inset 49 into the array and then display array

//11 22 3 66 88 44 33 99 77 49
//Press any key to continue . . .