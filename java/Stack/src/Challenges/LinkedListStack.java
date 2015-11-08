package Challenges;

public class LinkedListStack implements StackInterface{
	
	private class Node{
		public Object item;
		public Node next;
	}
	
	Node first = null;
	public LinkedListStack() {
		first = new Node();
		first.next = null;
	}
	
	public void push(Object item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
//		DEBUGGING
//		System.out.println("+ pushing " + item);
//		System.out.println("first value is " + first.item);
//		System.out.println("old value is " + oldFirst.item);
	}
	
	public Object pop() {
		Object oldItem = first.item;
		first = first.next;
//		DEBUGGING
//		System.out.println("- popping " + oldItem);
//		if (first != null)
//			System.out.println("first became " + first.item);
		return oldItem;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
