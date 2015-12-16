package Challenges;

public class Shell implements ISort{
	public void sort(int[] a){
		int h;
		int N = a.length;
		
		h = 1;
		System.out.println("N/3: " + (N/3));
		while(h < N / 3) h = h * 3 + 1;
		
		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
		
		while (h >= 1) {
			System.out.println("h is assigned with " + h + "\n\n");
			for (int i = h; i < N; i++) {
				System.out.println("i "+ i );
	            for (int j = i; j >= h && (a[j] < a[j-h]); j -= h) {
	                System.out.println("j " + j +" " + " a[j-h] " + a[j-h] + " a[j] " + a[j]);
	            	exch(a, j-h, j, h);
	            }
	        }
			h /= 3;
		}
		
		
	}

	private void exch(int[] a, int i, int j, int h) {
		System.out.println("exchaning j-h: " + i +", j: " + j + ", h:" + h);
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println("");
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
        for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
        System.out.println("");
		
	}
}
