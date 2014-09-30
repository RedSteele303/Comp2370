import java.util.ArrayList;

/**
 * CS2370 Fall 2014 Programming Assignment 1 
 *
 * @author [Insert name(s), email address(es), student number(s),
 *          and group number here for author(s)]
 * 
 * Example of how to use the CpuTimer class. You may use this code
 * as starter code for programming assignment 1. Replace this comment with
 * your own description.
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

		maxSize = Integer.parseInt(args[0]);
		//	System.out.println(maxSize);

		for (long n = minSize; n<=maxSize; n = n*10){
			//Part 1: Part 1 and 3
			ArrayList<Double> a = Sort.fillRandomArray(n);
			//Part 1: Part 2
			ArrayList<Double> b = new ArrayList<Double>();
			//Part 1:Part 4
			long timingIterations = (maxSize * 10)/n;

			System.out.println("Size of the array: " + n + "\n");
			//		System.out.println(timingIterations + "\n");

			//Part 1: Part 5
			CpuTimer timer1 = new CpuTimer();
			for(int j = 0; j<timingIterations; j++){
				b = Sort.copyArray(a);
			}
			averageCopyTime = timer1.getElapsedCpuTime()/timingIterations;
			System.out.println("Average Copy Time: " + averageCopyTime);

			//Part 1: Part 6
			CpuTimer timer2 = new CpuTimer();
			for(int j = 0; j<timingIterations; j++){
				b = Sort.insertionSort(a);
			}
			averageInsertionSortTime = (timer2.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			System.out.println("Average Insertion Sort Time: " + averageInsertionSortTime);

			//Part 1: Part 7
			CpuTimer timer3 = new CpuTimer();
			for(int j = 0; j<timingIterations; j++){
				b = Sort.mergeSort(a);
			}
			
			averageMergeSortTime = (timer3.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			System.out.println("Average Merge Sort Time: " + averageMergeSortTime);
			
			//Part 2: Part 1: Insertion Sort
			ArrayList<Double> preSorted = new ArrayList<Double>();
			for(Double i = 0.0; i < n; i++){
				preSorted.add(i);
			}

			CpuTimer timer4 = new CpuTimer();
			for(int i = 0; i<timingIterations; i++){
				b = Sort.insertionSort(preSorted);
			}
			
			averagePreSortedInsertionSortTime = (timer4.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			
			System.out.println("Average Insertion Sort Time for Presorted: " + averagePreSortedInsertionSortTime);
			
			//Part 2: Part 1: Merge Sort
			CpuTimer timer5 = new CpuTimer();
			for(int i = 0; i<timingIterations; i++){
				b = Sort.mergeSort(preSorted);
			}
			averagePreSortedMergeSortTime = (timer5.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			
			System.out.println("Average Merge Sort Time for Presorted: " + averagePreSortedMergeSortTime);
			
			//Part 2: Part 2: Insertion Sort
			ArrayList<Double> reverseOrder = new ArrayList<Double>();
			for(int i = (int) n; i > 0; i--){
				reverseOrder.add((double) i);
			}
			CpuTimer timer6 = new CpuTimer();
			for(int i = 0; i<timingIterations; i++){
				b = Sort.insertionSort(reverseOrder);
			}
			averageReverseOrderInsertionSortTime = (timer6.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			
			System.out.println("Average Insertion Sort Time for Reverse Order : " + averageReverseOrderInsertionSortTime);
			
			//Part 2: Part 2: Merge Sort
			CpuTimer timer7 = new CpuTimer();
			for(int i = 0; i<timingIterations; i++){
				b = Sort.mergeSort(reverseOrder);
			}
			averageReverseOrderMergeSortTime = (timer7.getElapsedCpuTime()/timingIterations)-averageCopyTime;
			if(!Sort.isSorted(b)){
				System.out.println("One of the array lists was not sorted properly.");
				System.exit(1);
			}
			
			System.out.println("Average Merge Sort Time for Reverse Order : " + averageReverseOrderMergeSortTime + "\n");
			

		}
		System.out.println("Testing complete.");


	}

}