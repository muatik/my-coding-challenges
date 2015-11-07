package UnionFind;

public class WeightedQuickUnion implements UnionFind{
	int[] nodes;
	int[] size;
	int processes;
	
	public WeightedQuickUnion(int n) {
		nodes = new int[n];
		size = new int[n];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
			size[i] = i;
		}
	}
	
	@Override
	public boolean isConnected(int nodeX, int nodeY) {
		processes++;
		return findRoot(nodeX) == findRoot(nodeY);
	}

	private int findRoot(int node) {
		while (node != nodes[node]) {
			node = nodes[node];
			processes++;
		}
		return node;
	}

	@Override
	public void union(int nodeX, int nodeY) {
		int rootX = findRoot(nodeX);
		int rootY = findRoot(nodeY);
		
		// small tree goes into the bigger one
		if (size[rootY] > size[rootX]) {
			size[rootY] += size[rootX];
			nodes[rootX] = rootY;
		}
		else {
			size[rootX] += size[rootY];
			nodes[rootY] = rootX;
		}
		
		processes += 2;
	}

	@Override
	public int getProcessCounter() {
		return processes;
	}

}
