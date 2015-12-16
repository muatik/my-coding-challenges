package muatik;

public class FarthestNodes {
	Object left, right; // the farthest left/right node.
	int distanceLeft, distanceRight; // distance to the farthest left/right node.
	int diameter; // path from left to right
	
	public FarthestNodes(Object left, int distanceLeft, Object right, int distanceRight, int pathLength) {
		this.left = left;
		this.distanceLeft = distanceLeft;
		this.right = right;
		this.distanceRight = distanceRight;
		this.diameter = pathLength;
	}
	
	public Object getFarthestNode() {
		if (distanceLeft > distanceRight)
			return left;
		return right;
	}
	
	public int getMaxDistance() {
		if (distanceLeft > distanceRight)
			return distanceLeft;
		return distanceRight;
	}
	
	public void increaseBy(Object tree) {
		if (distanceLeft > distanceRight) {
			right = tree;
			distanceRight = 0;
			distanceLeft++;
		} else {
			left = tree;
			distanceLeft = 0;
			distanceRight++;
		}
		diameter++;
	}
	
	public static FarthestNodes get(BTree tree) {
		FarthestNodes leftSub  = null;
		FarthestNodes rightSub = null;
		FarthestNodes r = null;
		
		if (tree.left !=null) 
			leftSub = get(tree.left);
		
		if (tree.right !=null) 
			rightSub = get(tree.right);
		
		if (tree.left != null && tree.right != null) {
			
			if (
				(leftSub.getMaxDistance() + rightSub.getMaxDistance() + 2) 
					> Math.max(leftSub.diameter, rightSub.diameter)	
				) 
			{
				r = new FarthestNodes(
						leftSub.getFarthestNode(),
						leftSub.getMaxDistance() + 1,
						rightSub.getFarthestNode(), 
						rightSub.getMaxDistance() + 1,
						leftSub.getMaxDistance() + rightSub.getMaxDistance() + 2);
			} else {
				r = (leftSub.diameter > rightSub.diameter ? leftSub : rightSub);
			}
			
		}
		else if (tree.left != null || tree.right != null) {
			r = (tree.left == null? rightSub : leftSub);
			if (r.getMaxDistance() + 1 > r.diameter) {
				r.increaseBy(tree);
			} else {
				r.distanceLeft++;
				r.distanceRight++;
			}
		} else {
			// tree has neither left node nor right node. 
			r = new FarthestNodes(
					tree, // farthest left node
					0, // distance to the left node
					tree, // farthest right node
					0, // distance to the right node
					0);  // longest path's length
		}
		
		return r;
	}
}
