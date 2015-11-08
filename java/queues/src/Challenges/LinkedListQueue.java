package Challenges;

public class LinkedListQueue implements QueueInterface {

	private class Node {
		public Object item;
		public Node next;
	}

	private Node last = null;
	private Node head;
	
	@Override
	public void enqueue(Object item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			head = last;
		} else {
			oldLast.next = last;
		}
	}

	@Override
	public Object dequeue() {
		Object item = head.item;
		head = head.next;
		if (isEmpty())
			last = null;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
