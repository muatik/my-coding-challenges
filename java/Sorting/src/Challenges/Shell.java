package Challenges;

public class Shell implements ISort{
	public void sort(int[] a){
		int h;
		int N = a.length;
		int comparision = 0;
		int modification = 0;
		
		h = 1;

		while(h < N / 3) h = h * 3 + 1;
		
		while (h >= 1) {
			// System.out.println("h is assigned with " + h + "\n\n");
			for (int i = h; i < N; i++) {
				comparision++;
	            for (int j = i; j >= h && (a[j] < a[j-h]); j -= h) {
	            	comparision++;
	                // System.out.println("j " + j +" " + " a[j-h] " + a[j-h] + " a[j] " + a[j]);
	            	exch(a, j-h, j, h);
	            	modification++;
	            }
	        }
			h /= 3;
		}
		
		System.out.println("\narray length: " + a.length);
		System.out.println("comparision: " + comparision);
		System.out.println("modification: " + modification);

		
	}

	private void exch(int[] a, int i, int j, int h) {
		// System.out.println("exchanging j-h: " + i +", j: " + j + ", h:" + h);
		
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
		
	}
}
