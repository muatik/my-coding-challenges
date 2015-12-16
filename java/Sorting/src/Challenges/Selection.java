package Challenges;

public class Selection implements ISort {
	public void sort(int[] array) {
		Integer min;
		int comparision = 0;
		int modification = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i+1; j < array.length; j++) {
				comparision++;
				if (array[j] < array[min]) 
					min = j;
			}
			if (min != i) {
				modification++;
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
		System.out.println(" ---- selection sort ---- ");
		System.out.println("array length: " + array.length);
		System.out.println("comparision: " + comparision);
		System.out.println("modification: " + modification);	}
}
