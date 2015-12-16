package Challenges;

public class example {
	public static void main(String[] args) {
		int[] n = {13, 36, 2, 5, 4, 14, 1, 9, 7, 3, 8, 6, 11, 65, 23, 15, 3, 17};
		System.out.println(" \n ####### INSERTION #########");
		new Shell().sort(n);
		//test(new Insertion());
		System.out.println("---- done ---");
		
	}
	
	public static void test(ISort sorter) {
		System.out.println("\n ####### preordered array #########");
		sorter.sort(new int[]{3, 4});
		sorter.sort(new int[]{3, 4, 5, 7});
		sorter.sort(new int[]{3, 4, 5, 7, 8, 9, 10, 11});
		sorter.sort(new int[]{3, 4, 5, 8, 9, 12, 16, 17, 34, 55, 66, 77});
		sorter.sort(new int[]{3, 4, 5, 8, 9, 12, 16, 18, 30, 32, 34, 52, 55, 56, 77, 99});
		System.out.println("\n ####### reversed array #########");
		sorter.sort(new int[]{4, 3});
		sorter.sort(new int[]{7, 5, 4, 3});
		sorter.sort(new int[]{11, 10, 9, 8, 7, 6, 5, 4});
		sorter.sort(new int[]{15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4});
		sorter.sort(new int[]{19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4});
		System.out.println("\n ####### partly preordered array #########");
		sorter.sort(new int[]{3, 4});
		sorter.sort(new int[]{3, 8, 5, 7});
		sorter.sort(new int[]{3, 4, 21, 7, 8, 9, 10, 11});
		sorter.sort(new int[]{3, 4, 21, 8, 9, 12, 16, 99, 34, 55, 66, 77});
		sorter.sort(new int[]{3, 4, 5, 8, 9, 90, 16, 18, 30, 32, 34, 52, 55, 56, 77, 99});
		System.out.println("\n ####### shuffled array #########");
		sorter.sort(new int[]{3, 4});
		sorter.sort(new int[]{31, 12, 5, 57});
		sorter.sort(new int[]{31, 14, 6, 1, 11, 39, 3, 89});
		sorter.sort(new int[]{3, 34, 1, 18, 59, 12, 26, 39, 32, 15, 66, 77});
		sorter.sort(new int[]{43, 41, 75, 8, 19, 3, 16, 38, 92, 12, 1, 3, 51, -2, 10, 32});
		
	}
}
