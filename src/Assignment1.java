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
	/**
	 * Program main
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {

		maxSize = Integer.parseInt(args[0]);
		//	System.out.println(maxSize);

		for (long n = minSize; n<maxSize; n = n*10){
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
			System.out.println("Average Merge Sort Time: " + averageMergeSortTime + "\n");

		}
		System.out.println("Testing complete.");


	}

}