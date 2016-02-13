package muatik;

public class Graph {
	
	protected int V; // number of vertices
	protected int E; // number of edges
	protected int edges[];
	protected AdjacencyList vertices[];
	
	public Graph(int v) {
		V = v;
		vertices = new AdjacencyList[V];
		for (int i = 0; i < V; i++) 
			vertices[i] = new AdjacencyList(V);
	}
	
	public void connect(int v, int w) {
		vertices[v].add(w);
		vertices[w].add(v);
	}
	
	public int V() {
		return V;
	}
	
	public Iterable<Integer> getAdjacents(int v) {
		return vertices[v];
	}
	
	public String toString() {
		System.out.println("Adjacency matrix:");
		for(int i = 0; i < V; i++) {
			System.out.println(i + " : " + vertices[i]);
		}
		return "";
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.connect(1, 4);
		g.connect(2, 4);
//		g.connect(1, 0);
		System.out.println(g);
		Graph_DFS d = new Graph_DFS(g,4);
		System.out.println(d.isConnected(0));
//		for(int i: g.getAdjacents(1))
//			System.out.println(i);
	}
}
