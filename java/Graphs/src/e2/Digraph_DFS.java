package e2;

import java.util.ArrayList;

public class Digraph_DFS {
	private int s;
	private boolean visits[];
	private int edgeTo[];
	private int visitCounter;
	private Digraph g;
	
	public Digraph_DFS(Digraph g, int s) {
		this.s = s;
		visits = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.g = g;
		dfs(g, s);
	}
	
	public void dfs(Digraph g, int v) {
		visits[v] = true;
		visitCounter++;
		for (int w: g.getAdjs(v)) {
			if (!isVisited(w)) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}
	
	public boolean isVisited(int v) {
		return visits[v];
	}
	public boolean hasPathTo(int v) {
		return isVisited(v);
	}
	
	public boolean isConnected() {
		return visitCounter == g.V();
	}
	
	public ArrayList<Integer> pathTo(int v) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		for (int i = v; i != s; i = edgeTo[i]) {
			path.add(i);
		}
		path.add(s);
		return path;
	}
	
}
