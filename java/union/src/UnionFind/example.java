package UnionFind;
import java.lang.System;

public class example {
	public static void main(String[] args) {
		
		System.out.println("quick find algorithm:");
		QuickFind qf = new QuickFind(10);
		testUnionFind(qf);
		
		System.out.println("quick union algorithm:");
		QuickUnion qu = new QuickUnion(10);
		testUnionFind(qu);
		
		System.out.println("weighted quick union algorithm:");
		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		testUnionFind(wqu);
	}
	
	static void testUnionFind(UnionFind u) {
		u.union(2, 1);
		u.union(3, 5);
		u.union(5, 6);
		System.out.println("Are 3 and 5 connected? " + u.isConnected(3, 5));
		System.out.println("Are 3 and 5 connected? " + u.isConnected(3, 5));
		System.out.println("Are 8 and 3 connected? " + u.isConnected(8, 3));
		u.union(5, 7);
		u.union(8, 1);
		u.union(1, 7);
		for (int i = 0; i < 20; i++) {
			u.isConnected(5, 8);
		}
		System.out.println("Are 8 and 3 connected? " + u.isConnected(8, 3));
		System.out.println("processes: " + u.getProcessCounter() + "\n");
	}
}
