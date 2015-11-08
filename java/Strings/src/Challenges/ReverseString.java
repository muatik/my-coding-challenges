package Challenges;

public class ReverseString {
	
	public static void main(String[] args) {
		System.out.println(reverse("this is an example. @! to"));
		System.out.println(reverse2("this is an example. @! to"));
		System.out.println(reverse3("this is an example. @! to"));
		
		long started;
		int repetition = 3000000;
		
		started = System.nanoTime();
		for (int i = 0; i < repetition; i++) 
			reverse("this is an example. @! to");
		System.out.println("reverse: " + (System.nanoTime() - started) / 1000000);
		
		started = System.nanoTime();
		for (int i = 0; i < repetition; i++) 
			reverse2("this is an example. @! to");
		System.out.println("reverse2: " + (System.nanoTime() - started) / 1000000);
		
		started = System.nanoTime();
		for (int i = 0; i < repetition; i++) 
			reverse3("this is an example. @! to");
		System.out.println("reverse3: " + (System.nanoTime() - started) / 1000000);

//		OUTPUT:
//		ot !@ .elpmaxe na si siht
//		ot !@ .elpmaxe na si siht
//		ot !@ .elpmaxe na si siht
//		reverse: 264
//		reverse2: 2842
//		reverse3: 364
	}
	
	public static String reverse2(String string) {
		String reversed = "";
		for (int i = string.length() - 1; i >= 0; --i)
			reversed += string.charAt(i);
		return reversed;
	}
	
	public static String reverse3(String string) {
		StringBuilder reversed = new StringBuilder(string.length());
		for (int i = string.length() - 1; i >= 0; --i)
			reversed.append(string.charAt(i));
		return reversed.toString();
	}
	
	public static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}
	
}
