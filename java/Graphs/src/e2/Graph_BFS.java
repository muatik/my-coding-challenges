package e2;

import java.util.ArrayList;

public class Graph_BFS {
	
	private int s;
	private boolean visits[];
	private int edgesTo[];
	
	public Graph_BFS(Graph g, int s) {
		visits = new boolean[g.V()];
		edgesTo = new int[g.V()];
		this.s = s;
		bfs(g, s);
	}
	
	private void bfs(Graph g, int v) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(v);
		visits[v] = true;
		
		while (!q.isEmpty()) {
			v = q.remove(0);
			System.out.println("\n" + v + " is being visited");
			for (int w: g.getAdjs(v)) {
				if (!isVisited(w)) {
					System.out.println(w + " is added to queue");
					visits[w] = true;
					edgesTo[w] = v;
					q.add(w);
				}
			}
			System.out.println(v + " is visited ##");
		}
	}
	
	private boolean isVisited(int v) {
		return visits[v];
	}
 	
	public ArrayList<Integer> getShortestPathTo(int v) {
		if (!visits[v])
			return null;
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (v != this.s) {
			path.add(v);
			v = edgesTo[v];
		}
		return path;
	}
	
//	private boolean[] visits;
//	private int visitsCount;
//	
//	public Graph_BFS(Graph g, int s) {
//		visits = new boolean[g.V()];
//		bfs(g, s);
//	}
//	
//	private void bfs(Graph g, int v) {
//		ArrayList<Integer> queue = new ArrayList<Integer>();
//		queue.add(v);
//		visits[v] = true;
//		
//		while (!queue.isEmpty()) {
//			int i = queue.remove(0);
//			for (int w: g.getAdjs(i)) {
//				if (!isVisited(w)) {
//					visits[w] = true;
//					queue.add(w);
//				}
//			}
//		}
//		
//	}
//	
//	private boolean isVisited(int v) {
//		System.out.println("Is " + v + " being visited?" + visits[v]);
//		return visits[v];
//	}
	
}
