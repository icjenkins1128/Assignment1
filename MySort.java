import java.util.Arrays;
import java.lang.Math;


public class MySort {

	public static void main(String[] args) {
		// int[] someArray = {5, 2, 1, 3, 6, 7};

		//Below tests the sorting algorithm of larger array and also keeping track of the time
		int[] someArray = new int[100000];
		int count = 0;
		int onehundredThousand = 100000;
		for(int i = 0; i < someArray.length - 1; i++){

			someArray[count++] = onehundredThousand--;

		}
		long startTime = System.currentTimeMillis();

		sort(someArray);

		long endTime = System.currentTimeMillis();

		for(int i = 0; i < someArray.length - 1; i++){

			System.out.print(someArray[i]+" ");

		}
		System.out.println("\n");
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		//System.out.println(Arrays.toString(someArray));
		
	}


	public static void sort(int[] arr) {

		//runs the helper method for my sort
        mySort(arr, 25000, arr.length);


     }


     //Hybrid sorting algorithm for that operates on large array of items
     public static void mySort(int[] a, int run_size, int arrSize){

     	//find runs and sort each run using insertion sort
     	 for (int i = 0; i < arrSize; i += run_size) {

     	 	int pos = i + 24999;
     	 	insertionSort(a, i, Math.min(pos, arrSize - 1)); 

     	 }

     	//based on the run size, we merge individual adjacent pairs of runs
     	 //double the size in order to allow for space for further merges
		for (int size = run_size; size < arrSize; size = size * 2) { 
    		
    		//Merge the sub arrays. Then increase the left size by 2 to merge the next runs
        	for (int left = 0; left < arrSize; left += size * 2) { 
            	
            	int mid = left + size - 1; 
            	int right = Math.min((left + size * 2 - 1), (arrSize - 1)); 
  
            
            //merges the sorted runs
           	    merge(a, left, mid, right); 
        	} 
    	} 


     }

     public static void insertionSort(int[] a, int l, int r) {
        
		for(int i = l + 1; i < r; i++){

			int temp = a[i];

			int k = i - 1;

			while(k >= l && a[k] > temp){

				a[k + 1] = a[k];
				k--;
			}

			a[k + 1] = temp;

		}

	}


     public static void merge(int targetArr[], int l, int mid, int r){

		int leftSize = mid - l + 1;
     	int rightSize = r - mid;

     	// Create temp arrays 
        int leftArr[] = new int [leftSize]; 
        int rightArr[] = new int [rightSize]; 
  
        //Copy data to temp arrays
        for (int i=0; i<leftSize; ++i){
            leftArr[i] = targetArr[l + i]; 
        }
        for (int j=0; j<rightSize; ++j){
            rightArr[j] = targetArr[mid + 1 + j]; 
        }

		int left = 0;
		int right = 0;
		int target = l;

		while(left < leftSize && right < rightSize){

			if(leftArr[left] <= rightArr[right]){

				targetArr[target++] = leftArr[left++];
				

			}else{

				targetArr[target++] = rightArr[right++];
				
			}
			


		}

		while(left < leftSize){

			targetArr[target++] = leftArr[left++];
			
		}

		while(right < rightSize){

			targetArr[target++] = rightArr[right++];

		}

	}


}