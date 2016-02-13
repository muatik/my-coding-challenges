package e2;

public class Bag {
	
	private int capacity;
	private int size;
	private int[] edges;
	
	public Bag(int capacity) {
		this.capacity = capacity;
		edges = new int[capacity];
	}
	
	public void add(int w) {
		edges[size++] = w;
	}
	
	
	public int[] get() {
		int adj[] = new int[size];
		for (int i = 0; i < size; i++) 
			adj[i] = edges[i];
		return adj;
	}
}
