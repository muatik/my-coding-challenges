package muatik;

public class Graph_DFS {
	
	private int s; // source vertex
	private boolean visits[];
	
	public Graph_DFS(Graph g, int v) {
		this.s = v;
		visits = new boolean[g.V()];
		DFS(g, v);
	}
	
	public void DFS(Graph g, int v) {
		visits[v] = true;
		for(int w: g.getAdjacents(v)) {
			if (!isVisited(w)) {
				DFS(g, w);
			}
		}
	}

	private boolean isVisited(int v) {
		return visits[v];
	}
	
	public boolean isConnected(int w) {
		return isVisited(w);
	}
}
