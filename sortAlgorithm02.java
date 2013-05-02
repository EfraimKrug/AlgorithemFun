package Algorithm02;

public class sortAlgorithm02 {
	public static void main(String[] args) {

		//test array to sort... should be able to
		//change size & order. It must be an array
		//of ints
		// tested empty/one element/25 elements...
		int[] targetArray = {
				5, 3, 2, 1, 4, 0,
				6, 9, 8, 7, 10, 27,
				15, 12, 13, 11, 14,
				16, 20, 19, 18, 17,
				24, 23, 25, 22, 21,26
		};

		//print the original array,
		//then sort it with whichever sort
		//you want, then print it again!
		printOut(targetArray);
		//this is just a check to make sure scope is
		//working the way I think it should.
		
		//doZeroForCheck(targetArray);
		
		//now working on Merge Sort
		doMergeSort(targetArray);
		
		
		//and print out final results.
		printOut(targetArray);
	}	
	
	//I am going to blast my way through this in my
	//own, klutzy in-elegant way... what do you want?
	//I'm from Kansas! And my little dog, too!
	//enter: the merge sort... ta dah!
	public static void doMergeSort(int[] targetArray){
		int first = 0;
		int last = targetArray.length - 1;
		mergeAndSort(targetArray, first, last);
	}
	
	//mergeAndSort - recursive array
	//splits array into two pieces - each time pieces are smaller and smaller until they are only one element
	//then we pass the array and the 3 indices to mergeArrays - so they can be sorted and merged!
	//@param targetArray - array of integers to sort
	//@param first - index to first element of targetArray - changes via recursive calls
	//@param last - index to last element of targetArray - changes via recursive calls
	//@affect targetArray - is overwritten with sorted output
	
	public static void mergeAndSort(int[] targetArray, int first, int last){
		if(first < last){
			int middle = (last + first)/2;
			mergeAndSort(targetArray, first, middle);
			mergeAndSort(targetArray, middle+1, last);
			mergeArrays(targetArray, first, middle, last);
		}
	}
	
	//mergeArrays
	//@param targetArray - array we are sorting, and also the array we are writing into
	//@param first - index to the first element of the piece of targetArray
	//@param middle - index determined in mergeAndSort
	//@param last - index to last element of the targetArray
	//@affect: affects the targetArray - by sorting elements - you can't get back from here!
	public static void mergeArrays(int[] targetArray, int first, int middle, int last){
		int n1 = middle - first;
		int n2 = last - middle;
	
		int[] leftArray = new int[n1+2];
		int[] rightArray = new int[n2+3];
		
		// copy left side
		for(int i=0; i <= n1; i++){
			leftArray[i] = targetArray[first+i];
		}
	
		leftArray[n1+1] = 99;
		
		// copy right side: start copying 1 past middle
		for(int i=1; i <= n2; i++){
			rightArray[i-1] = targetArray[middle+i];
		}
		
		rightArray[n2] = 99;
		int i = 0;
		int j = 0;
		
		// guard against moving the sentinels...
		for (int k=first; k <= last; k++){
			if(leftArray[i]<=rightArray[j]){
				if(leftArray[i]< 99){
					targetArray[k] = leftArray[i];
					i++;
				}
			}
			else {
				if(rightArray[j] < 99){
					targetArray[k] = rightArray[j];
					j++;
				}
			}
		}
	}
	
	public static void printOut(int[] printArray){
		System.out.println("\n========= THE ARRAY ==========");
		for(int i = 0; i < printArray.length; i++){
			System.out.print(printArray[i] + ",");
		}
	}
}
