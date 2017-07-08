import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created by muatik on 7/8/17.
 */
public class LevelOrderTraversing {
    static String levelOrder(Solution.Node root) {
        Queue<Solution.Node> q = new LinkedList<>();
        q.add(root);
        Solution.Node n;
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            n= q.remove();

            if (n.left != null)
                q.add(n.left);

            if (n.right != null)
                q.add(n.right);

            sb.append(n.data + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution.BTree<Integer> t = new Solution.BTree<>();
        Stream.of("1 2 5 3 6 4".split(" "))
                .mapToInt(Integer::valueOf)
                .forEach(a -> {
                    t.add(Integer.valueOf(a));
                });

        if (levelOrder(t.root).equals("1 2 5 3 6 4"))
            throw new Exception("printing topView failed");
    }
}
