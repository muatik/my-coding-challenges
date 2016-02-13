package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph_DFS {
	int s; // source vertex
	boolean visits[];
	int visitCounter;
	int edgeTo[];
	
	Graph g;
	
	public Graph_DFS(Graph g, int s) {
		this.s = s;
		this.g = g;
		visits = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	private void dfs(Graph g, int v) {
		System.out.println(v + " is being visited");
		visits[v] = true;
		visitCounter++;
		for (int w: g.getAdjs(v)) {
			if (!isVisited(w)) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
		System.out.println(v + " is visited. ----");
	}
	
	public boolean isVisited(int v) {
		System.out.println("Is " + v + " being visited?" + visits[v]);
		return visits[v];
	}
	
	public boolean hasPathTo(int v) {
		return isVisited(v);
	}
	
	public ArrayList<Integer> pathTo(int v) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int i = v; i != s; i = edgeTo[i]) {
			path.add(i);
		}
		path.add(s);
		return path;
	}
	
	public boolean isConnected() {
		return visitCounter == g.V();
	}
	
}
