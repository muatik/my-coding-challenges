package Challenges;


public class FixedArrayStack implements StackInterface{
	
	private Object[] stack;
	private int last = -1;
	
	public FixedArrayStack(int size) {
		stack = new Object[size];
	}
	
	@Override
	public void push(Object item) {
		stack[++last] = item; 
	}

	@Override
	public Object pop() {
		Object popped = stack[last];
		stack[last--] = null;
		return popped;
	}

	@Override
	public boolean isEmpty() {
		return last == -1;
	}

}
