package Challenges;

public class GenericFixedArrayStack<Item> {
	
	private Item[] stack;
	private int last = -1;
	
	public GenericFixedArrayStack(int size) {
		stack = (Item[]) new Object[size];
	}
	
	public void push(Item item) {
		stack[++last] = item; 
	}

	public Item pop() {
		Item popped = stack[last];
		stack[last--] = null;
		return popped;
	}

	public boolean isEmpty() {
		return last == -1;
	}

}
