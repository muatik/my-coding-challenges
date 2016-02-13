package Challenges;

public class MergeSort implements ISort{
	
	public void sort(int[] array) {
		int[] aux = new int[array.length];
		sort(array, aux, 0, array.length - 1);
	}
	
	static void sort(int[] array, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		
		int mid = lo + (hi-lo) / 2;
		sort(array, aux, lo, mid);
		sort(array, aux, mid + 1, hi);
		merge(array, aux, lo, mid, hi);
	}
	
	static void merge(int[] array, int[] aux, int lo, int mid, int hi) {
		System.out.println("lo " + lo + " , mid " + mid + " , hi " + hi);
		
		for (int k = lo; k <= hi; k++) {
            aux[k] = array[k]; 
        }
		
		int j = mid + 1;
		int i = lo;
		for (int k = lo; k <= hi; k++) {
			if (mid < i) 					array[k] = aux[j++]; // if left part is exhausted, put the element from the right part.
			else if (hi < j ) 				array[k] = aux[i++]; // if the right part exhausted, put from the left.
			else if (aux[j] < aux[i]) 		array[k] = aux[j++];
			else 							array[k] = aux[i++];
		}
	}
	
//	public static void main(String[] args) {
//		int[] input = new int[]{11 ,8, -9, 12, 5};
//		sort(input);
//		for(int i: input ) {
//			System.out.println(i);
//		}
//	}
}
