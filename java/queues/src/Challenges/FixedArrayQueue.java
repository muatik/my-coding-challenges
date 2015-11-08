package Challenges;

public class FixedArrayQueue implements QueueInterface{
	
	private Object[] nodes;
	int head = 0;
	int tail = 1;
	
	public FixedArrayQueue(int size) {
		nodes = new Object[size + 1];
	}
	
	@Override
	public void enqueue(Object item) {
		// reached the end of the array?
		if (tail == nodes.length) {
			// and is queue is full?
			if (head == 0)
				return; // nothing to do.
			else
				tail = 0; // point to the beginning of the array
		}
		nodes[tail++] = item;
	}

	@Override
	public Object dequeue() {
		if (isEmpty())
			return null;
		if (head + 1 == nodes.length) {
			if (tail != 0)
				head = -1;
			else
				return null;
		}
		Object item = nodes[++head];
		nodes[head] = null;
		
		return item;
	}

	@Override
	public boolean isEmpty() {
		return tail - head == 1;
	}

}
