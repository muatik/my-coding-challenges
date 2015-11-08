package Challenges;

public class FixedArrayQueue2 implements QueueInterface{

	private Object[] nodes;
	int head = 0;
	int tail = -1;
	int size = 0;
	
	public FixedArrayQueue2(int length) {
		nodes = new Object[length];
	}
	
	@Override
	public void enqueue(Object item) {
		if (size == nodes.length)
			return;
		
		size++;
		
		if (isEmpty()) { 
			nodes[tail] = item;
			return;
		}
		
		tail = (tail + 1) % nodes.length;
		nodes[tail] = item;		
	}

	@Override
	public Object dequeue() {
		if (isEmpty())
			return null;
		size--;
		Object item = nodes[head];
		nodes[head] = null;
		head = (head + 1) % nodes.length;
		
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
}
