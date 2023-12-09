package LinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Main {
    public static void deleteNode_A(ListNode node) {
        if (node == null || node.next == null) {
            // Cannot delete the last node or a null node
            return;
        }

        // Copy the data from the next node to the current node
        node.val = node.next.val;

        // Update the next pointer to skip the next node
        node.next = node.next.next;
    }

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            // Cannot delete the last node or a null node
            return;
        }

        // Swap values with the next node
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        // Update the next pointer to skip the next node
        node.next = node.next.next;
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode nodeToDelete = head.next; // Node with value 5

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Delete the node
        deleteNode(nodeToDelete);

        System.out.println("Linked List after deletion:");
        printLinkedList(head);
    }
}
