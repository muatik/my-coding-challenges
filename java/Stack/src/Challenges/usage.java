package Challenges;

import java.util.Random;

public class usage {
	public static void main(String[] args) {
		
//		GENERIC FIXED ARRAY STACK USAGE
//		-----------------------------
//		GenericFixedArrayStack<String> genStack = new GenericFixedArrayStack<>(10);
//		genStack.push("das");
//		genStack.push("123");
//		genStack.pop();
//		genStack.push(123); // compile time error; types mismatches.
	
//		ITERABLE GENERIC FIXED ARRAY STACK USAGE
//		-----------------------------
//		IterableGenericFixedArrayStack<Integer> iterableStack;
//		iterableStack = new IterableGenericFixedArrayStack<>(5);
//		iterableStack.push(4);
//		iterableStack.push(2);
//		iterableStack.push(9);
//		for (Integer item : iterableStack) {
//			System.out.println(item);
//		}
		
		
		
		int size = 1000000 * 4; // 4 millions
		
		LinkedListStack ll = new LinkedListStack();
		testStack(ll, size);
		
		FixedArrayStack fixedStack = new FixedArrayStack(4000001);
		testStack(fixedStack, size);
		
		ResizableArrayStack resizableStack = new ResizableArrayStack(10000);
		testStack(resizableStack, size);
		
		testStack(ll, 100000);
		testStack(fixedStack, 100000);
		testStack(resizableStack, 100000);
//		OUTPUT
//		size: 4000000, overall 3.59260838 seconds elapsed. class Challenges.LinkedListStack
//		size: 4000000, overall 0.189466172 seconds elapsed. class Challenges.FixedArrayStack
//		size: 4000000, overall 0.28655294 seconds elapsed. class Challenges.ResizableArrayStack
//		size: 100000, overall 0.002567492 seconds elapsed. class Challenges.LinkedListStack
//		size: 100000, overall 0.001950209 seconds elapsed. class Challenges.FixedArrayStack
//		size: 100000, overall 0.004852134 seconds elapsed. class Challenges.ResizableArrayStack

	}
	
	public static void testStack(StackInterface stack, int size) {
		long startedAt = System.nanoTime(); 
		Random random = new Random();
		
		// we assume that stack has length of 4.000.000
		
		// testing pushing
		for (int i = 0; i < size; i++) 
			stack.push(random.nextInt(1000));
		
		// testing popping
		for (int i = 0; i < 10000; i++) 
			stack.pop();
		
		// filling the stack again.
		for (int i = 0; i < 10000; i++) 
			stack.push(random.nextInt(100));
		
		// pushing and popping for testing of resizing performance
		for (int i = 0; i < 10000; i++) {
			stack.push(random.nextInt(1000));
			stack.pop();
		}
		
		
		while (!stack.isEmpty())
			stack.pop();
		
		System.out.println("size: " + size + ", overall " 
				+ (System.nanoTime() - startedAt) / 1000000000.0
				+ " seconds elapsed. " + stack.getClass());
		
	}
}
