import java.util.ArrayList;
import java.util.Random;


public class Sort {

	public static ArrayList<Double> fillRandomArray(long size)
	{
		//This method takes in an integer size
		//gets a new random number generator
		Random rand = new Random();
		ArrayList<Double> newList = new ArrayList<Double>();
		//fills the arraylist with random doubles
		for (int i = 0; i <= size ; i ++)
		{
			newList.add(i, rand.nextDouble());
		}
		return newList;
	}
	//simple method to copy the arraylist and return a new list
	public static ArrayList<Double> copyArray(ArrayList<Double> someList)
	{
		ArrayList<Double> copyList = someList;
		return copyList;

	}
	//checks to see if at any point, there is a value that is greater than the value that follows it
	public static boolean isSorted(ArrayList<Double> someList)
	{
		boolean sorted = true;        
		for (int i = 1; i < someList.size(); i++) {
			if (someList.get(i-1) > someList.get(i)){
				sorted = false;
			}
		}
		return sorted;
	}
	public static ArrayList<Double> insertionSort(ArrayList<Double> someList)
	{
		//This method takes in an ArrayList that is not sorted and will use the insertion sort
		//method and return the ArrayList in proper order

		for (int j = 1; j < someList.size(); j++ )
		{
			Double key = someList.get(j);
			//insert someList{j} into the sorted sequence someList{1...j-1}
			int i = j - 1;
			while (i >= 0 && someList.get(i) > key)
			{
				someList.set(i + 1, someList.get(i));
				i = i-1;
			}
			someList.set(i + 1, key);

		}
		return someList;
	}
	//This method takes two arrays and breaks them down into single units and merges them back in ascending order
	public static ArrayList<Double> merge(ArrayList<Double> leftList, ArrayList<Double> rightList) {
	    if (leftList.size() == 0) {
	      return rightList;
	    }
	    if (rightList.size() == 0) {
	      return leftList;
	    }
	    ArrayList<Double> result = new ArrayList<>();
	    Double nextElement;
	    if (leftList.get(0) > rightList.get(0)) {
	      nextElement = rightList.get(0);
	      rightList.remove(0);
	    } else {
	      nextElement = leftList.get(0);
	      leftList.remove(0);
	    }
	    result.add(nextElement);
	    result.addAll(merge(leftList,rightList));
	    return result;
	  }
	
	public static ArrayList<Double> mergeSort(ArrayList<Double> a) {
	    if (a.size() <= 1) {
	      return a;
	    }
	    ArrayList<Double> firstHalf = new ArrayList<>();
	    ArrayList<Double> secondHalf = new ArrayList<>();
	    for (int i = 0; i < a.size() / 2; i++) {
	      firstHalf.add(a.get(i));
	    }
	    for (int i = a.size() / 2; i < a.size(); i++) {
	      secondHalf.add(a.get(i));
	    }
	    return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	  }

}