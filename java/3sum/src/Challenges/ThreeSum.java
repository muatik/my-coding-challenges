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
				12, 6, -2,-8,-4, -6, -1, -5, -7, 2, 1, -7, 10, -10, 11, -11};
		find3sum(numbers);
//		OUTPUT will be as follows:
//		12 + -2 + -10 = 0
//		12 + -8 + -4 = 0
//		12 + -1 + -11 = 0
//		12 + -5 + -7 = 0
//		12 + -5 + -7 = 0
//		6 + -2 + -4 = 0
//		6 + -8 + 2 = 0
//		6 + -1 + -5 = 0
//		6 + -7 + 1 = 0
//		6 + 1 + -7 = 0
//		-2 + -8 + 10 = 0
//		-4 + -6 + 10 = 0
//		-4 + -7 + 11 = 0
//		-4 + -7 + 11 = 0
//		-6 + -5 + 11 = 0
//		-1 + -10 + 11 = 0
//		1 + 10 + -11 = 0
//		stesp:560

	}
}
