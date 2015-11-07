package UnionFind;

public interface UnionFind {
	public boolean isConnected(int nodeX, int nodeY);
	public void union(int nodeX, int nodeY);
	public int getProcessCounter();
}
