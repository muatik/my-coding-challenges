package UnionFind;

public class QuickFind implements UnionFind{
	int[] nodes;
	int processes = 0;
	public QuickFind(int n) {
		nodes = new int[n];
		// populatiing nodes
		for (int i = 0; i < n; i++)
			nodes[i] = i;
	}
	
	public void union(int nodeX, int nodeY) {
		int find = nodes[nodeX];
		for (int i = 0; i < nodes.length; i++)
			if (nodes[i] == find) {
				processes++;
				nodes[i] = nodes[nodeY];
			}
	}
	
	public boolean isConnected(int nodeX, int nodeY) {
		processes++;
		return nodes[nodeX] == nodes[nodeY];
	}
	
	public int getProcessCounter() {
		return processes;
	}
}
