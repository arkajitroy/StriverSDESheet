package BinaryTree;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}
    TreeNode(int x) {
        this.val = x;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private static void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.val);
            inorderRecursive(node.right, result);
        }
    }

    public static List<Integer> inorderIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while(true){     // current is not null & stack is not empty
            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                if(stack.isEmpty()) break;

                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    // Main function for testing
    public static void main(String[] args) {
        /*
         * Example tree:
         *    1
         *     \
         *      2
         *     /
         *    3
         */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
