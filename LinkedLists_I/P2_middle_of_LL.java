package LinkedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public static ListNode findMiddle(ListNode node){
        if(node == null) return null;

        ListNode slow = node, fast = node;

        while(fast != null && fast.next != null){
            slow = slow.next;   // moving by 1 step
            fast = fast.next.next;  // moving by 2 steps
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = findMiddle(head);

        System.out.println("The Middle of the Linked Lists is:"+result.val);
    }
}
