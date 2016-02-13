package muatik;

public class MaxPriorityQueue {
	
	protected int length = 0;
	protected int size;
	protected int items[];
	
	public MaxPriorityQueue(int size) {
		this.size = size;
		
		// since the 0th index will not be used for arithmetic heap operations, allocate size + 1
		this.items = new int[size + 1]; 
	}
	
	public void insert(int key) {
		items[++length] = key;
		swim(length);
	}
	
	public int delMax() {
		int key = items[1];
		items[1] = items[length--];
		sink(1);
		return key;
		
	}
	
	protected void swim(int current) {
		while ((current / 2) > 0 && items[current/2] < items[current] ) {
			exchange(current / 2, current);
			current = current / 2;
		}
	}
	
	protected void sink(int current) {
		int descendant = 0;
		while (current * 2 <= length) {
			descendant = current * 2;
			if (items[descendant] < items[descendant+1]) descendant++;
			if (items[descendant] <= items[current]) 
				break;
			
			exchange(descendant, current);
			current *= 2;
		}
	}
	
	protected void exchange(int i, int j) {
		int temp = items[j];
		items[j] = items[i];
		items[i] = temp;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue a = new MaxPriorityQueue(10);
		a.insert(5);
		a.insert(12);
		a.insert(7);
		a.insert(-4);
		a.insert(19);
		a.insert(15);
		a.insert(10);
		a.insert(98);
		a.delMax();
		a.display();
		while (!a.isEmpty())
			System.out.println(a.delMax());
	}

	private void display() {
		for (int j = 1; j < length; j++) {
			System.out.println(items[j]);
		}
	}
}
