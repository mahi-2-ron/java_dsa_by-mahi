
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class recur_travel {

    static class Node {

        int data;
        Node left;
        Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }

        Node(int x, Node left, Node right) {
            this.data = x;
            this.left = left;
            this.right = right;

        }
    }

    public static void inorderPrint(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left, list);

        list.add(root.data);
        inorderPrint(root.right, list);
    }

    public static List<Integer> inorderPrint(Node root) {
        List<Integer> list = new ArrayList<>();
        inorderPrint(root, list);
        return list;
    }

    public static void preorderPrint(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //System.out.println(root.data);
        list.add(root.data);
        preorderPrint(root.left, list);
        preorderPrint(root.right, list);
    }

    public static List<Integer> preorderPrint(Node root) {
        List<Integer> list = new ArrayList<>();
        preorderPrint(root, list);
        return list;
    }

    public static List<Integer> postorderTraversel(Node root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversel(root, list);
        return list;
    }

    public static void postorderTraversel(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorderTraversel(root.left);
        postorderTraversel(root.right);
        list.add(root.data);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();   // get the front node in the queue
                level.add(node.data);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello Good morning");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        List<Integer> result = preorderPrint(root);
        System.out.println("Inorder Traversel : ");

    }
}
