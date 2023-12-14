package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Main {
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private static void recursive(TreeNode node, List<Integer> result){
        if (node == null) return;

        recursive(node.left, result);
        recursive(node.right, result);
        result.add(node.val);
    }

    public static List<Integer> postorderTraversal_Itt(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node != null){
                stack.push(root.left);
                stack.push(root.right);
                result.add(0, root.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> postorder = postorderTraversal(root);
        List<Integer> postorder_itt = postorderTraversal_Itt(root);

        System.out.println("Postorder Traversal Result: " + postorder);
    }
}
