package muatik;

public class BTree {
	
	public String key;
	public BTree left;
	public BTree right;
	public BTree root;
	
	public BTree(String key) {
		this.key = key;
		root = this;
	}
	
	public void insert(String key) {
		insert(root, key);
	}
	
	public void insert(BTree tree, String key) {
		int comparing = key.compareTo(tree.key);
		if (comparing < 1) {
			if (tree.left != null)
				insert(tree.left, key);
			else
				tree.left = new BTree(key);
		} else {
			if (tree.right !=null)
				insert(tree.right, key);
			else
				tree.right = new BTree(key);
		}
	}
	
	public static void display(BTree tree) {
		if (tree == null)
			return;
		
		display(tree.left);
		display(tree.right);
		System.out.println(tree.key);
	}
}
