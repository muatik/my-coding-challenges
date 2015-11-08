package Challenges;


public class ThreeSum {
	
	// time complexity is O(n^3), that is, this is quite slow.
	public static int find3sum(int[] numbers) {
		int counter = 0;
		int steps = 0;
		for (int i = 0; i < numbers.length - 2; i++) 
			for (int j = i + 1; j < numbers.length - 1; j++) 
				for (int k = j + 1; k < numbers.length; k++)  {
					steps++;
					if ( (numbers[i] + numbers[j] + numbers[k]) == 0) {
						System.out.println(
								numbers[i] + " + " + numbers[j] + " + " + numbers[k] +
										" = 0");
						counter++;
					}
				}
		System.out.println("stesp:" + steps);
		return counter;
	}
	
	public static void main(String args[]) {
		int[] numbers = new int[]{
				12, 6, -2,-8,-4, -6, -1, -5, -7, 6, 2, 1, -7, 10, -10, 11, -11};
		numbers = new int[]{-8, -6, -4, -2, -1, 3, 6, 7, 4, 10};
		find3sum(numbers);
	}
}
