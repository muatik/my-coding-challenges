package e2;

public class Digraph {
	
	private int V;
	private Bag adjs[];
	private int indegree[];
	
	public Digraph(int V) {
		this.V = V;
		indegree = new int[V];
		adjs = new Bag[V];
		for (int i = 0; i < V; i++)
			adjs[i] = new Bag(V);
	}
	
	public void add(int v, int w) {
		adjs[v].add(w);
		indegree[w]++;
	}
	
	public int getOutdegree(int v) {
		return adjs[v].get().length;
	}
	
	public int getIndegree(int v) {
		return indegree[v];
	}
	
	public int[] getAdjs(int v) {
		return adjs[v].get();
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
		Digraph g = new Digraph(12);
		g.add(1, 0);
		g.add(1, 2);
		g.add(0, 2);
		g.add(2, 4);
		g.add(4, 3);
		g.add(3, 4);
		g.add(4, 5);
		g.add(4, 6);
		g.add(6, 7);
		g.add(7, 8);
		g.add(8, 6);
		g.add(8, 9);
		g.add(9, 2);
		//g.add(9, 3);
		System.out.println(g);
		System.out.println(g.getIndegree(6));
		
		Digraph_DFS dfs = new Digraph_DFS(g, 4);
		System.out.println("is 6 visited? " + dfs.isVisited(6));
		System.out.println("Graph is connected?  " + dfs.isConnected());
		
		System.out.println("\npath from " + 4 + " to " + 2);
		for(int i : dfs.pathTo(2))
			System.out.print(i + ", ");
	}
}
