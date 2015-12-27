package muatik;

public class Example {
	public static void main(String[] args) {
//		BTree t = new BTree(16);
//		t.insert(8);
//		t.insert(9);
//		t.insert(27);
//		t.insert(2);
//		t.insert(12);
//		t.remove(9);
//		t.displayPostOrder();
//		System.out.println(t.contains(12));
//		
		
		BTree_BFS t2 = new BTree_BFS(5);
		t2.insert(2);
		t2.insert(1);
		t2.insert(6);
		t2.insert(4);
		t2.insert(3);
		t2.insert(20);
		t2.insert(9);
		t2.insert(10);
		t2.insert(21);
		t2.insert(22);
		t2.insert(23);
		t2.insert(16);
		t2.insert(15);
		t2.insert(14);
		System.out.println(t2.contains(192));
		System.out.println(t2.BFS(124));
		
		BTree_DFS t3 = new BTree_DFS(5);
		t3.insert(2);
		t3.insert(1);
		t3.insert(6);
		t3.insert(4);
		t3.insert(3);
		t3.insert(20);
		t3.insert(9);
		System.out.println(t3.DFS(20));
	}
}
