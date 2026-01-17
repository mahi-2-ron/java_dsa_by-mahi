
import java.util.ArrayList;
import java.util.List;
import java.util.*;

class iter_travel {

    static class Node {

        int data;
        Node left;
        Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }

        Node(int x, Node left, Node right) {
            this.data = x;
            this.left = left;
            this.right = right;

        }
    }

    static List<Integer> preorderTraversel(Node root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            preorder.add(root.data);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> res = preorderTraversel(root);
        System.out.print("Preorder Traversal: ");
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
