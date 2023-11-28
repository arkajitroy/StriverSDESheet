package LinkedLists_Arrays;

class Main{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Perform k rotations
        k = k % length;
        for (int i = 0; i < k; i++) {
            // Move the last node to the front
            ListNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail.next = head;
            head = tail;
            current.next = null;
            tail = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode rotatedHead = rotateRight(head, k);

        // Print the rotated linked list
        while (rotatedHead != null) {
            System.out.print(rotatedHead.val + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}