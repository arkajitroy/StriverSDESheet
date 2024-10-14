package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

// BFS APPROACH : O(n) | O(n)
class BFS{
    public static Node connect(Node root){
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;
            for(int i=0; i<size; i++){
                Node currentNode = queue.poll();

                // set the next pointer
                if(prev != null) prev.next = currentNode;
                prev = currentNode;

                // adding the children to the queue
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return root;
    }
}

class ConstantSpace{
    public static Node connect(Node root){
        if(root == null) return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node head = leftMost;

            while (head != null) {
                // link left child to right child
                head.left.next = head.right;
                // link right child to the next node's left child
                if(head.next != null) head.right.next = head.next.left;

                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}



class solve {
    public static void main(String[] args) {
        // building a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    }
}
