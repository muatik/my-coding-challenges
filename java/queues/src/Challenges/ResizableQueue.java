package Challenges;

public class ResizableQueue implements QueueInterface{
	
	private Object[] nodes;
	int head = 0;
	int tail = -1;
	int size = 0;
	
	public ResizableQueue() {
		this(1000);
	}
	
	public ResizableQueue(int length) {
		nodes = new Object[length];
	}
	
	@Override
	public void enqueue(Object item) {
		if ((tail + 1)== nodes.length)
			resize((size + 1)* 2);
		
		size++;
		
		if (isEmpty()) {
			nodes[tail] = item;
//			display();
			return;
		}
		
		nodes[++tail] = item;
//		display();
	}

	@Override
	public Object dequeue() {
		if (nodes.length / 3 > size)
			resize(nodes.length / 2);
		if (isEmpty())
			return null;
		size--;
		Object item = nodes[head];
		nodes[head] = null;
		head++;
//		display();
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void resize(int length) {
		Object[] newNodes = new Object[length];
		for (int i = 0; i < size; i++) 
			newNodes[i] = nodes[i+head];
		head = 0;
		tail = size -1;
		nodes = newNodes;
//		display();
	}

	private void display() {
		System.out.println("-------");
		for (int i = 0; i < nodes.length; i++) {
			System.out.println("i: " + i + ", val: " + nodes[i]);
		}
		
	}
	
	

}
