import java.util.stream.Stream;

/**
 * Created by muatik on 7/10/17.
 */
public class HeightOfTree {
    public static void main(String[] args) throws Exception {
        Solution.BTree<Integer> t = new Solution.BTree<>();
        Stream.of("3 5 2 1 4 6 7".split(" "))
                .mapToInt(Integer::valueOf)
                .forEach(t::add);

        System.out.println(t.printPreOrder());
        if (findHeight(t.root) == 3)
            throw new Exception("printing topView failed");

    }

    private static int findHeight(Solution.Node<Integer> root) {
        return findHeightHelper(root, 0);
    }

    private static int findHeightHelper(Solution.Node<Integer> root, int h) {
        if (root == null) {
            return h;
        } else {
            return Math.max(
                    findHeightHelper(root.left, h+1),
                    findHeightHelper(root.right, h+1));
        }
    }
}
