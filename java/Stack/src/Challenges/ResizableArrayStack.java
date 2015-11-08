package Challenges;

public class ResizableArrayStack implements StackInterface {
	
	private Object[] stack;
	private int last = -1;
	
	public ResizableArrayStack(int size) {
		stack = new Object[size];
	}
	
	@Override
	public void push(Object item) {
//		System.out.println("last " + last + " length " + stack.length);
		if (last + 1 == stack.length) {
			// stack is full. we increase the size of the stack at the rate of %50
			resize((int) (stack.length * 1.5));
		}
		stack[++last] = item;
	}

	@Override
	public Object pop() {
		Object oldItem = stack[last];
		stack[last--] = null;
//		System.out.println("last " + last + ", " + stack.length);
		if (stack.length / 4 > (last + 1))
			resize(stack.length / 2);
		return oldItem;
	}

	@Override
	public boolean isEmpty() {
		return last == -1;
	}
	
	protected void resize(int newSize) {
//		System.out.println("last " + last + ", resizing the stack as length of " + newSize);
		if (newSize == 0)
			newSize = 1;
		Object[] newStack = new Object[newSize];
		for (int i = 0; i < newSize && i < stack.length; i++) 
			newStack[i] = stack[i];
		stack = newStack;
	}

}
