package LinkedLists_Arrays;

/**
 * P2_clone_linked_list_random_pointer
 */

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Main {

    public static Node copyRandomList(Node head){
        if(head == null) return null;

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

         // Step 2: Update random pointers of copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Split the modified list into original and copied lists
        current = head;
        Node copiedHead = head.next;
        Node copiedCurrent = copiedHead;
        while (current != null) {
            current.next = copiedCurrent.next;
            current = current.next;
            if (current != null) {
                copiedCurrent.next = current.next;
                copiedCurrent = copiedCurrent.next;
            }
        }

        return copiedHead;
    }

    // Utility function to print the linked list for testing
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("(" + current.val + ", ");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print(") -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample linked list with random pointers
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node2;
        head.random = node3;
        node2.next = node3;
        node2.random = head;
        node3.next = node4;
        node3.random = node2;
        node4.random = node4;

        // Print the original list with random pointers
        System.out.println("Original List with Random Pointers:");
        printList(head);

        // Make a deep copy of the list
        Node copiedHead = copyRandomList(head);

        // Print the copied list with random pointers
        System.out.println("\nCopied List with Random Pointers:");
        printList(copiedHead);
    }
}