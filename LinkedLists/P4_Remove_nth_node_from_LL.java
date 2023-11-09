package LinkedLists;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution{

    public static ListNode removeNthNodeFromEnd(ListNode head, int size){
        ListNode start = new ListNode();
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;

        for(int i=1; i<size; i++){
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // assigning the pointer to next to next

        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        ListNode result = removeNthNodeFromEnd(head, n);
    }
}