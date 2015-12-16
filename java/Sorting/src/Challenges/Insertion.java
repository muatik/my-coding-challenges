package Challenges;

public class Insertion implements ISort {
	public void sort(int[] array) {
		int comparision = 0;
		int modification = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				comparision++;
				if (array[i] < array[j]) {
					modification++;
					exchange(array, i, j);
				} else {
					// because left side of the list will always be sorted.
					break;
				}
			}
		}
		System.out.println("\narray length: " + array.length);
		System.out.println("comparision: " + comparision);
		System.out.println("modification: " + modification);

	}
	
	public static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
