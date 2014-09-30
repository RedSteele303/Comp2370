import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CS2370 Fall 2014 Programming Assignment 1 
 *
 * @author [Sean Steele and Marshall Miller, steele.sean303@gmail.com marshalldavidmiller@gmail.com,
 * 			872676708 872767994, Group 6]
 * 
 * Finished CPU timer class including all of both parts 1 and 2 finished and working.
 *
 */

public class Assignment1 {
	public static int minSize = 10;
	public static int maxSize;
	public static double averageCopyTime, averageInsertionSortTime;
	public static double averageMergeSortTime;
	private static double averagePreSortedMergeSortTime;
	private static double averagePreSortedInsertionSortTime;
	private static double averageReverseOrderMergeSortTime;
	private static double averageReverseOrderInsertionSortTime;
	/**
	 * Program main
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {

		//create filewriter and printwriter for csv
		FileWriter fwriter;
		try {
			fwriter = new FileWriter ("Asssignment1Data.csv");

			PrintWriter outputFile = new PrintWriter (fwriter);
			outputFile.println("nmax, n, Sort, CPU Seconds");
			//Takes the max size of the array based off the user input.
			maxSize = Integer.parseInt(args[0]);

			for (long n = minSize; n<=maxSize; n = n*10){
				//Part 1: Part 1 and 3 Creates a new arraylist and fills it with random doubles
				ArrayList<Double> a = Sort.fillRandomArray(n);
				//Part 1: Part 2 Creates a second arraylist that will contain the sorted arrays
				ArrayList<Double> b = new ArrayList<Double>();
				//Part 1:Part 4 Finds the timing iterations for the given max from the args
				long timingIterations = (maxSize * 10)/n;


				//Part 1: Part 5 Tests the timing of copy array for each n
				CpuTimer timer1 = new CpuTimer();
				for(int j = 0; j<timingIterations; j++){
					b = Sort.copyArray(a);
				}
				averageCopyTime = timer1.getElapsedCpuTime()/timingIterations;

				//Part 1: Part 6 Tests the timing of insertion sort of a randomly filled array of "n" length
				CpuTimer timer2 = new CpuTimer();
				for(int j = 0; j<timingIterations; j++){
					b = Sort.insertionSort(a);
				}
				//Obtains the average time
				averageInsertionSortTime = (timer2.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				//Makes sure that the finished array is sorted. If not, exit the program.
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}
				outputFile.println(maxSize + ", " + n + ", " + "IR" + ", " + averageInsertionSortTime);

				//Part 1: Part 7 Tests the timing of merge sort on a randomly filled array of "n" length
				CpuTimer timer3 = new CpuTimer();
				for(int j = 0; j<timingIterations; j++){
					b = Sort.mergeSort(a);
				}
				//Obtains the average time
				averageMergeSortTime = (timer3.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				//Checks to make sure that the array is sorted
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}
				outputFile.println(maxSize + ", " + n + ", " + "MR" + ", " + averageMergeSortTime);


				//Part 2: Part 1: Insertion 
				//Creates an array of "n" length in ascending order
				ArrayList<Double> preSorted = new ArrayList<Double>();
				for(Double i = 0.0; i < n; i++){
					preSorted.add(i);
				}
				//Tests the timing of insertion sort on a pre-sorted array
				CpuTimer timer4 = new CpuTimer();
				for(int i = 0; i<timingIterations; i++){
					b = Sort.insertionSort(preSorted);
				}
				averagePreSortedInsertionSortTime = (timer4.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}

				outputFile.println(maxSize + ", " + n + ", " + "IA" + ", " + averagePreSortedInsertionSortTime);


				//Part 2: Part 1: Merge Sort Tests the timing of merge sort on a presorted array
				CpuTimer timer5 = new CpuTimer();
				for(int i = 0; i<timingIterations; i++){
					b = Sort.mergeSort(preSorted);
				}
				averagePreSortedMergeSortTime = (timer5.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}

				outputFile.println(maxSize + ", " + n + ", " + "MA" + ", " +  averagePreSortedMergeSortTime);

				//Part 2: Part 2: Insertion Sort Tests the timing of insertion sort on an array in reverse order
				//Creates an array with length "n" and in descending order
				ArrayList<Double> reverseOrder = new ArrayList<Double>();
				for(int i = (int) n; i > 0; i--){
					reverseOrder.add((double) i);
				}
				//Tests the timing of insertion
				CpuTimer timer6 = new CpuTimer();
				for(int i = 0; i<timingIterations; i++){
					b = Sort.insertionSort(reverseOrder);
				}
				averageReverseOrderInsertionSortTime = (timer6.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}

				outputFile.println(maxSize + ", " + n + ", " + "ID" + ", " + averageReverseOrderInsertionSortTime );

				//Part 2: Part 2: Merge Sort Tests the timing of merge sort on an array in descending order
				CpuTimer timer7 = new CpuTimer();
				for(int i = 0; i<timingIterations; i++){
					b = Sort.mergeSort(reverseOrder);
				}
				averageReverseOrderMergeSortTime = (timer7.getElapsedCpuTime()/timingIterations)-averageCopyTime;
				if(!Sort.isSorted(b)){
					System.out.println("One of the array lists was not sorted properly.");
					System.exit(1);
				}

				outputFile.println(maxSize + ", " + n + ", " + "MD" + ", " +averageReverseOrderMergeSortTime + "\n");


			}
			//Close out the file reader.
			outputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}