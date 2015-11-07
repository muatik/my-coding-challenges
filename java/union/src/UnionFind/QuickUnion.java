package UnionFind;


public class QuickUnion implements UnionFind{
	int[] nodes;
	int processes = 0;
	public QuickUnion(int n) {
		nodes = new int[n];
		for (int i = 0; i < nodes.length; i++) 
			nodes[i] = i;
		
	}
	
	public void union(int nodeX, int nodeY) {
		nodes[findRoot(nodeX)] = findRoot(nodeY);
		processes++;
	}

	public int findRoot(int node) {
		while (node != nodes[node]) {
			processes++;
			node = nodes[node];
		}
		return node;
	}
	
	public boolean isConnected(int nodeX, int nodeY) {
		processes++;
		return findRoot(nodeX) == findRoot(nodeY);
	}
	
	public int getProcessCounter() {
		return processes;
	}
}
