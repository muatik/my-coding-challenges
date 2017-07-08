import java.util.stream.Stream;

/**
 * Created by muatik on 7/8/17.
 */
public class Solution {

    static class Node<T extends Comparable> {
        T data;
        Node<T> left;
        Node<T> right;
        public Node(T d) {
            data = d;
        }
    }

    static class BTree<T extends Comparable>{
        Node<T> root;

        public void add(T d) {

            if (root == null) {
                root = new Node<>(d);
            } else {
                addHelper(root, d);
            }
        }

        public void addHelper(Node root, T d) {

            if (d.compareTo(root.data) == -1 ) {
                if (root.left != null)
                    addHelper(root.left, d);
                else
                    root.left = new Node<>(d);
            } else {
                if (root.right != null)
                    addHelper(root.right, d);
                else
                    root.right = new Node<>(d);
            }
        }

        public String printPreOrder() {
            StringBuilder sb = new StringBuilder();
            BTree.printPreOrder(this.root, sb);
            return sb.toString();
        }

        public static StringBuilder printPreOrder(Node node, StringBuilder sb) {
            if (node == null)
                return sb;

            sb.append(node.data).append(" ");

            if (node.left != null)
                sb = printPreOrder(node.left, sb);
            if (node.right != null)
                sb = printPreOrder(node.right, sb);
            return sb;
        }
    }

    public static void main(String[] args) {
        BTree<Integer> t = new BTree<>();

        Stream.of("20, 40, 10, 17, 14, 13, 18, 5, 7, 4, 82, 39".split(", "))
                .mapToInt(Integer::valueOf)
                .forEach(a->{
                    t.add(Integer.valueOf(a));
                });

        assert (t.printPreOrder().equals("20 10 5 4 7 17 14 13 18 40 39 82 "));

    }
}
