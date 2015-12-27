package muatik;

public class BTree_DFS extends BTree {

	public BTree_DFS(Comparable key) {
		super(key);
	}
	
	public boolean DFS(Comparable key) {
		return DFS(this, key);
	}
	
	
	/**
	 * pre-ordered depth-first-search on the given tree
	 * @param tree
	 * @param key
	 * @return
	 */
	public static boolean DFS(BTree tree, Comparable key) {
		if (tree == null)
			return false;
		
		int comparision = key.compareTo(tree.key);
		
		if (comparision == 0)
			return true;
		
		return (comparision < 0 ? DFS(tree.left, key) : DFS(tree.right, key));
	}
}
