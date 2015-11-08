package Challenges;

public class exmaple {
	
	public static void main(String[] args) {
		LinkedListQueue llq = new LinkedListQueue();
		testCorrectness(llq);
		
		FixedArrayQueue farrq = new FixedArrayQueue(4);
		testCorrectness(farrq);
		
		FixedArrayQueue2 farrq2 = new FixedArrayQueue2(4);
		testCorrectness(farrq2);
		
		ResizableQueue rarrq = new ResizableQueue(4);
		testCorrectness(rarrq);
		
		int size = 2000000;
		benchmark(llq, size);
		benchmark(new FixedArrayQueue(size), size);
		benchmark(new FixedArrayQueue2(size), size);
		benchmark(new ResizableQueue(1000), size);
		
//		OUTPUT
//		size: 2000000, overall 2.74073758 seconds elapsed. class Challenges.LinkedListQueue
//		size: 2000000, overall 0.240556205 seconds elapsed. class Challenges.FixedArrayQueue
//		size: 2000000, overall 0.139172042 seconds elapsed. class Challenges.FixedArrayQueue2
//		size: 2000000, overall 0.098690218 seconds elapsed. class Challenges.ResizableQueue

	}
	
	public static void testCorrectness(QueueInterface q) {
		if (!q.isEmpty())
			throw new AssertionError("queue is not empty");
		
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(7);
		
		if ((int) q.dequeue() != 4)
			throw new AssertionError("dequeu must have return 4");
		q.enqueue(9);
		if ((int) q.dequeue() != 5)
			throw new AssertionError("dequeu must have return 5");
		if ((int) q.dequeue() != 7)
			throw new AssertionError("dequeu must have return 7");
		q.enqueue(3);
		if ((int) q.dequeue() != 9)
			throw new AssertionError("dequeu must have return 9");
		q.enqueue(1);
		if ((int) q.dequeue() != 3)
			throw new AssertionError("dequeu must have return 3");
		if ((int) q.dequeue() != 1)
			throw new AssertionError("dequeu must have return 1");
		q.enqueue(2);
		q.enqueue(33);
		q.enqueue(34);
		q.enqueue(35);
		q.enqueue(36);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(37);
		q.enqueue(38);
		q.enqueue(39);
		q.enqueue(40);
	}
	
	public static void benchmark(QueueInterface q, int size) {
		long startedAt = System.nanoTime(); 
		for (int i = 0; i < size; i++)
			q.enqueue(i);
		
		for (int i = 0; i < size; i++) {
			q.enqueue(i);
			q.dequeue();
		}
		
		for (int i = 0; i < size; i++) 
			q.dequeue();
		
		System.out.println("size: " + size + ", overall " 
				+ (System.nanoTime() - startedAt) / 1000000000.0
				+ " seconds elapsed. " + q.getClass());
	}
	
	
}
