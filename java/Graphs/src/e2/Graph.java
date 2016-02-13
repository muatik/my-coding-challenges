package e2;

import java.util.ArrayList;

public class Graph {
	
	protected int V;
	protected Bag adjs[];
	
	public Graph(int V) {
		this.V = V;
		adjs = new Bag[V];
		for (int i = 0; i < V; i++) {
			adjs[i] = new Bag(V);
		}
		
	}
	
	public void add(int v, int w) {
		adjs[v].add(w);
		adjs[w].add(v);
	}
	
	public int V() {
		return V;
	}
	
	public String toString() {
		for(int i = 0; i < V; i++) {
			System.out.print(i + ": ");
			for(int a: adjs[i].get())
				System.out.print(a + ", ");
			System.out.print("\n");
		}
		return "";
	}

	
	public static void main(String[] args) {
		Graph g = new Graph(12);
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 2);
		g.add(1, 3);
		g.add(2, 3);
		g.add(3, 4);
		g.add(4, 5);
		g.add(4, 6);
		g.add(5, 6);
		g.add(4, 7);
		g.add(3, 7);
		g.add(7, 8);
		g.add(8, 9);
		g.add(9, 10);
		g.add(9, 3);
		System.out.println(g);
		Graph_DFS dfs = new Graph_DFS(g, 2);
		System.out.println("is 6 visited? " + dfs.isVisited(6));
		System.out.println("Graph is connected?  " + dfs.isConnected());
		
		System.out.println("\npath from " + 2 + " to " + 10);
		for(int i : dfs.pathTo(10))
			System.out.print(i + ", ");
		
		
		Graph_BFS bfs = new Graph_BFS(g, 1);
		for (int i = 0; i < g.V(); i++) {
			ArrayList<Integer> path = bfs.getShortestPathTo(i);
			System.out.print("\n\npath to " + i + ": ");
			if (path == null) {
				System.out.println("not connected to " + i);
				continue;
			}
			for(int w: path)
				System.out.print(w + " <-- ");
			System.out.print(1);
		}
		
	}
	
	public int[] getAdjs(int v) {
		return adjs[v].get();
	}
	
}
