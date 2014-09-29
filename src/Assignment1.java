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

    /**
     * Program main
     * 
     * @param args
     */
    public static void main(String[] args)  {
	CpuTimer timer = new CpuTimer();
                
	for (long i = 0; i < 500000; ++i) {
		ArrayList<Double> a = Sort.fillRandomArray(11);
		ArrayList<Double> b = Sort.copyArray(a);
		ArrayList<Double> c = Sort.copyArray(a);
		
		b = Sort.mergeSort(b);
		
		c = Sort.insertionSort(c);
	}
                
	System.out.println("CPU time = " + timer.getElapsedCpuTime());
    }

}