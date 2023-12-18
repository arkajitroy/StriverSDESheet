package LinkedLists_II;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main{
    public static boolean hasCycle_using_HashSet(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if(fast.next == null || fast == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        boolean cycleDetect = hasCycle(head);
        System.out.println("Has Cycle: "+cycleDetect);
    }
}