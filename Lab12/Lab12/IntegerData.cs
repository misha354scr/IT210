﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
 public class IntegerData {
	//Two fields or instance variables. 
	private int[] arr;
	private int iNumElements; 	//# of elements in the array, not the size of the array.

	//Constructor. Initializes both instance variables. Does not
	// create a new array.
	public IntegerData(int[] arr, int iNumElements){
		this.arr = arr;
		this.iNumElements = iNumElements;
	}

	/**
	 * Displays the element at index i
	 * @param i the index of the element to display
	 */
	public void DisplayAt(int i){
		//if i is a valid index, print the element at i
		if (i >= 0 && i < iNumElements){
		Console.WriteLine("Value at index {0} is: {1}", i,  arr[i]);
		}
		//let the user know that the index is invalid
		else{
			Console.WriteLine("{0} is not a valid index for this array", i);
		}
	}	

	/**
	 * displays the values of the array
	 */
	public void DisplayAll (){
	
		//print all the elements in array arr
		for (int i = 0; i < iNumElements; i++){
			Console.Write("{0} ", arr[i]);
		}	
   }
	
	/**  Finds a value in the array 
	 * @param key - value to search in the array
	 * @return - first index at which key was found. 
	 * 	         Returns -1 if key not found
	 */
	public int Find(int key){
		
		//iterate through the elements of the array
		for (int i = 0; i < iNumElements; i++){
			//if found value key, return index at which it was found
			if (arr[i] == key) return i;
		}
		
		//return -1 if key is not a value in the array
		return -1;
	}
	
	// delete 'key' from the array. 
	// which means that you must move up rest of the elements.
	public void Delete(int key){
		int index = Find(key); //find the index of the value to be deleted

		//if an element with value key was found
		if (index > 0){
			//remove the element. i.e.
			//copy the subarray {arr[index + 1]...arr[iNumElements - 1]}
			//to {arr[index]...arr[iNumElements - 2}
				Array.Copy(arr, index + 1, arr, index, iNumElements - index - 1);
		}
		
		//decrement the array element counter
		iNumElements--;
	}

	// sorts the array using the bubblesort sorting algorithm.
		public void bubbleSort() {
			int outer, inner;
			int temp;

			for (outer = iNumElements - 1; outer > 0; outer--) // outer loop (backward)
			{
				for (inner = 0; inner < outer; inner++) // inner loop (forward)
				{

					// combined the old "swap" into the "if" loop
					if (arr[inner] > arr[outer + 1]) {
						temp = arr[inner];
						arr[inner] = arr[inner + 1];
						arr[inner + 1] = temp;
					} // end if
				} // inner for loop
			} // outer for loop
		} // end bubbleSort()

		/**
		 * 	This method insert adds a new int into the array and increment iNumElements (count) by one. 
		 * @param n the number to insert
		 */
		public void insert(int n){
			//if arr has filled up, increase its size by a factor of 2
			if (arr.Length == iNumElements){
				int [] newArr = new int[iNumElements * 2];
            Array.Copy(arr, newArr, iNumElements);
				arr = newArr;
			}
			
			//insert the value and increment the values counter
			arr[iNumElements] = n;
			iNumElements++;
		}
   }
}
