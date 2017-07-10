import java.util.stream.Stream;

/**
 * Created by muatik on 7/8/17.
 */
public class TopViewTree {
    static StringBuilder sb = new StringBuilder();
    static void topView(Solution.Node root) {
        topViewLeft(root.left);
        sb.append(root.data+" ");
        topViewRight(root.right);
    }

    static void topViewLeft(Solution.Node root) {
        if (root != null) {
            topViewLeft(root.left);
            sb.append(root.data+" ");
        }
    }

    static void topViewRight(Solution.Node root) {
        if (root != null) {
            sb.append(root.data+" ");
            topViewRight(root.right);
        }
    }

    public static void main(String[] args) throws Exception {
        Solution.BTree<Integer> t = new Solution.BTree<>();
        Stream.of("1 2 5 3 6 4".split(" "))
                .mapToInt(Integer::valueOf)
                .forEach(a -> {
                    t.add(Integer.valueOf(a));
                });

        topView(t.root);
        if (sb.toString().equals("1 2 5 6"))
            throw new Exception("printing topView failed");

    }
}
