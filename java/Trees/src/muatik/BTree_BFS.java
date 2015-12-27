package muatik;

import java.util.ArrayList;
import java.util.LinkedList;

public class BTree_BFS extends BTree{
	
	public BTree_BFS(Comparable key) {
		super(key);
	}
	

	/**
	 * searches for the given key and returns true if it exists
	 * @param key
	 * @return
	 */
	public boolean BFS(Comparable key) {
		LinkedList<BTree> q = new LinkedList<BTree>();
		q.add(this);
		while (!q.isEmpty()) {
			BTree s = q.pop(); // here s refers to a node of this tree.
			
			if (s.key.compareTo(key) == 0) {
				return true;
			}
			
			if (s.left != null)
				q.add(s.left);
			if (s.right != null)
				q.add(s.right);
			
		}
		return false;
	}

}
