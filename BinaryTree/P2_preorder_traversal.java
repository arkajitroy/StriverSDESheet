package BinaryTree;
import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Solution {

    public static List<Integer> preorderTraversal_Recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Call the recursive helper function
        preorder_recursion(root, result);
        return result;
    }

    public static void preorder_recursion(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        preorder_recursion(root.left, result);
        preorder_recursion(root.right, result);

    }

    public static List<Integer> preorderTraversal_Iterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        // Check if the root is null
        if (root == null) {
            return result;
        }

        // Use a stack to keep track of nodes to be processed
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Push the right child first (if it exists)
            if (node.right != null) {
                stack.push(node.right);
            }
            // Push the left child (if it exists)
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Call the preorderTraversal function
        List<Integer> result = preorderTraversal_Recursion(root);

        // Print the result
        System.out.println(result);
    }
}
