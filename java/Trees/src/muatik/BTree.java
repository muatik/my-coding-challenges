package muatik;

public class BTree<Item extends Comparable<Item>> {
	
	protected BTree left; // left subtree of this tree
	protected BTree right; // right subtree of this tree
	protected Item key; // key of this node

	public BTree(Item key) {
		this.key = key;
	}
	
	
	/**
	 * insert the given key as a new node into this tree.
	 * @param key
	 */
	public void insert(Item key) {
		insert(this, key);
	}
	
	
	/**
	 * inserts the given key as a new node into the given tree
	 * @param tree
	 * @param key
	 */
	public void insert(BTree tree, Item key) {
		int comparision = key.compareTo((Item) tree.key);
		if (comparision < 1) {
			if (tree.left != null) 
				insert(tree.left, key);
			else
				tree.left = new BTree(key);
		} else {
			if (tree.right != null)
				insert(tree.right, key);
			else
				tree.right = new BTree(key);
		}
	}
	
	
	/**
	 * finds the minimum node in this tree.
	 * @return
	 */
	public Item findMin() {
		BTree minBTree = findMin(this);
		return (Item) minBTree.key;
	}
	
	
 	/**
	 * finds the minimum node in the given BTree
	 * @param tree
	 * @return minimum BTree node as a BTree instance
	 */
	public static BTree findMin(BTree tree) {
		if (tree.left == null)
			return tree;
		return findMin(tree.left);
	}
	
	
	/**
	 * finds the maximum node in this tree
	 * @return
	 */
	public Item findMax() {
		BTree found = findMax(this);
		return (Item) found.key;
	}
	
	
	/**
	 * finds the maximum node in the given tree
	 * @param tree
	 * @return
	 */
	public BTree findMax(BTree tree) {
		if (tree.right != null)
			return findMax(tree.right);
		return tree;
	}
	
	
	/**
	 * checks whether this tree contains the given key or not.
	 * @param key
	 * @return
	 */
	public boolean contains(Item  key) {
		return find(this, key) != null;
	}
	
	
	/**
	 * looks for the given key in the given tree and returns it if exists
	 * @param tree
	 * @param key
	 * @return
	 */
	public BTree find(BTree tree, Item key) {
		if (tree == null)
			return null;
		
		int comparision = key.compareTo((Item) tree.key);
		
		if (comparision == 0) {
			return tree;
		} else if (comparision < 0) {
			return find(tree.left, key);
		} else {
			return find(tree.right, key);
		}
	}
	
	
	/**
	 * removes the node corresponding to the given key
	 * @param key
	 */
	public void remove(Item key) {
		BTree nodeToBeRemoved = find(this, key);
		if (nodeToBeRemoved == null)
			return;

		if (nodeToBeRemoved.right != null) {
			BTree nodeSubsitution = findMin(nodeToBeRemoved.right);
			nodeToBeRemoved.key =  nodeSubsitution.key;
			nodeSubsitution = null;
		} else if (nodeToBeRemoved.left !=null ) {
			nodeToBeRemoved =  nodeToBeRemoved.left;
		} else {
			nodeToBeRemoved = null;
		}
	}

	public void displayPostOrder() {
		displayPostOrder(this);
	}

	public static void displayPostOrder(BTree tree) {
		if (tree.left != null)
			displayPostOrder(tree.left);
		if (tree.right != null)
			displayPostOrder(tree.right);
		System.out.println(tree.key);
	}

	public String toString() {
		return key.toString();
	}
	
}
