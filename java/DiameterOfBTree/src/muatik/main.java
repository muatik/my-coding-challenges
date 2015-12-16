package muatik;


public class main {
	
	public static void main(String[] args) {
		BTree tree = new BTree("h");
		
//		tree.insert("c");
//		tree.insert("b");
//		tree.insert("a");
//		tree.insert("d");
//		tree.insert("f");
//		tree.insert("g");
// 		== greatest distance 5, left: a, right: g
		
		
		tree.insert("c");
		tree.insert("b");
		tree.insert("a");
		tree.insert("d");
		tree.insert("f");
		tree.insert("g");
		
		tree.insert("m10");
		tree.insert("k10");
		tree.insert("k9");
		tree.insert("k8");
		tree.insert("k7");
		tree.insert("k6");
		tree.insert("k5");
		tree.insert("k4");
		tree.insert("p5");
		tree.insert("p6");
		tree.insert("p7");
		tree.insert("p4");
		tree.insert("p8");
		tree.insert("p9");
		
		
		BTree.display(tree);
		FarthestNodes r = FarthestNodes.get(tree);
		System.out.println(
				"greatest distance: " + r.diameter 
				+ ", left: " + ((BTree) r.left).key 
				+ ", right: " + ((BTree) r.right).key);
	}
	
}
