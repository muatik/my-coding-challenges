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

    static class BTree<T extends Comparable> {
        Node<T> root;

        public void add(T d) {

            if (root == null) {
                root = new Node<>(d);
            } else {
                addHelper(root, d);
            }
        }

        public void addHelper(Node root, T d) {

            if (d.compareTo(root.data) == -1) {
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

        public String printPostOrder() {
            StringBuilder sb = new StringBuilder();
            BTree.printPostOrder(this.root, sb);
            return sb.toString();
        }

        public String printInOrder() {
            StringBuilder sb = new StringBuilder();
            BTree.printInOrder(this.root, sb);
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

        public static StringBuilder printPostOrder(Node node, StringBuilder sb) {
            if (node != null) {
                sb = printPostOrder(node.left, sb);
                sb = printPostOrder(node.right, sb);
                sb.append(node.data).append(" ");
            }
            return sb;
        }

        public static StringBuilder printInOrder(Node node, StringBuilder sb) {
            if (node != null) {
                sb = printInOrder(node.left, sb);
                sb.append(node.data).append(" ");
                sb = printInOrder(node.right, sb);
            }
            return sb;
        }

        public int length() {
            return lengthHelper(root);
        }

        private int lengthHelper(Node<T> root) {
            if (root == null)
                return 0;

            return Math.max(lengthHelper(root.left), lengthHelper(root.right)) + 1;
        }
    }


    public static void main(String[] args) throws Exception {
        BTree<Integer> t = new BTree<>();

        Stream.of("20, 40, 10, 17, 14, 13, 18, 5, 7, 4, 82, 39".split(", "))
                .mapToInt(Integer::valueOf)
                .forEach(a -> {
                    t.add(Integer.valueOf(a));
                });

        if (t.printPreOrder().equals("20 10 5 4 7 17 14 13 18 40 39 82"))
            throw new Exception("preOrder printing failed");

        if (t.printInOrder().equals("4 5 7 10 13 14 17 18 20 39 40 82"))
            throw new Exception("inOrder printing failed");

        if (t.printPostOrder().equals("4 7 5 13 14 18 17 10 39 82 40 20"))
            throw new Exception("postOrder printing failed");
        System.out.println(t.length());
    }
}
