package algorithems01;
/**
 * Insertion Sort is the first sort to do.... the first sort
 * in the book. But the class is going to be a chassis for a
 * number of different sorts.
 * 
 * This is also the counting sort... very cool!
 */
 
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//test array to sort... should be able to
		//change size & order. It must be an array
		//of ints
		int[] targetArray = {
				5, 3, 2, 1, 4,
				6, 9, 8, 7, 10,
				15, 12, 13, 11, 14,
				16, 20, 19, 18, 17,
				24, 23, 25, 22, 21
		};
		//print the original array,
		//then sort it with whichever sort
		//you want, then print it again!
		printOut(targetArray);
		//insertion sort is done and works...
		doInsertionSort(targetArray);
		
		//this is just a check to make sure scope is
		//working the way I think it should.
		
		//doZeroForCheck(targetArray);
		
		// Uncomment the next line, and comment "doInsertionSort..." line
		//doCountingSort(targetArray);
		
		//and print out final results.
		printOut(targetArray);
	}	
	
	//actual insertion sort; sorts array in place
	public static void doInsertionSort(int[] targetArray){
		int i, key;
			for (int j = 1; j < targetArray.length; j++){
					key = targetArray[j];
					for (i=j-1;(i>=0)&&(targetArray[i] > key);i--){
						targetArray[i+1] = targetArray[i];
					}
					targetArray[i+1] = key;
			}
		}
	
	public static void doCountingSort(int[] targetArray){
	//all ints in sorted array must be between 0 and 30; i.e. k=30;
	int[] finalArray = new int[targetArray.length];
	int[] holdArray = new int[30]; // k = 30
	
	int k = 30; // need to guarantee there are no numbers in the array > k
	int i, j;
	//initialize holdArray
	for(i = 0; i < k; i++){
		holdArray[i]=0;
		}
	//count what we got!
	for(j = 1; j < targetArray.length; j++){
		holdArray[targetArray[j]] = holdArray[targetArray[j]] + 1;
		}
	//holdArray will now be a list of the number of elements less than the index!
	//in other words: holdArray[2] = hA[0] + hA[1] + hA[2]... etc!
	for(i = 1; i < k; i++){
		holdArray[i] = holdArray[i] + holdArray[i-1];
		}
	//Let's say the target array is: 3,2,1,4,2
	//holdArray had: 0,1,2,1,1
	//holdArray now has: 0,1,3,4,5 (after the last for loop)
	//I know what the total length is, so I can fill the final array from
	//the end.
	//Walk through next for loop:
	//targetArray[0] = 3; holdArray[3] = 4; finalArray[4] <-- targetArray[0] = 3
	//finalArray = {0,0,0,0,3}
	//NEXT:
	//targetArray[1] = 2; holdArray[2] = 3; finalArray[3] <-- targetArray[1] = 2
	//finalArray = {0,0,0,2,3}
	//NEXT: targetArray[2] = 1; holdArray[1] = 1; finalArray[1] <-- targetArray[2] = 1
	//finalArray = {0,1,0,2,3}
	//NEXT: targetArray[3] = 4; holdArray[4] = 5; finalArray[5] <-- targetArray[3] = 4
	//finalArray = {0,1,0,2,3,4}
	//NEXT: targetArray[4] = 2; holdArray[2] = 3; finalArray[3] <-- targetArray[4] = 2
	//*** oh NO! we messed up! we just moved 2 into the 4th slot of our final array
	//*** for a SECOND time... that is why we have to decrement the holdArray each
	//*** time - imagine that we had been decrementing (the second line of the 
	//*** for-loop below... then it would be:
	//CHANGE THAT AND DO OVER: targetArray[4] = 2; holdArray[2] = 2 (now!); finalArray[2] <-- targetArray[4] = 2	
	//finalArray = {0,1,2<--(what an algorithm! they think of everything! ),2,3}
	//and so on and so forth - to sound pedantic...
	for(j = targetArray.length-1; j > 0; j--){
		finalArray[holdArray[targetArray[j]]] = targetArray[j];
		holdArray[targetArray[j]] = holdArray[targetArray[j]] - 1;
		}
	//now let's just copy the final array into our original array:
	for(j=0;j<finalArray.length;j++){
		targetArray[j] = finalArray[j];
		}
	}
	
	//quick check to make sure everything is scoped right
	public static void doZeroForCheck(int[] targetArray){
		for(int i=0; i < targetArray.length; i++){
			targetArray[i] = 9;
		}
	}
	
	
	public static void printOut(int[] printArray){
		System.out.println("\n========= THE ARRAY ==========");
		for(int i = 0; i < printArray.length; i++){
			System.out.print(printArray[i] + ",");
		}
	}
}
