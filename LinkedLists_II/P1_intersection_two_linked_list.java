package LinkedLists_II;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {
    // brute force approach
    public static ListNode getIntersectionNode_Brute(ListNode headA, ListNode headB){
        while (headA != headB) {
            ListNode temp_B = headB;
            while (temp_B != null) {
                if(headA == temp_B) return headA;
                temp_B = temp_B.next;    
            }
            headA = headA.next;    
        }
        return null;
    }

    public static ListNode getIntersectionNode_Better(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }

    

    public static void main(String[] args) {
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        // Find the intersection node
        ListNode intersectionNode_brute = getIntersectionNode_Brute(headA, headB);
        ListNode intersectionNode_better = getIntersectionNode_Better(headA, headB);

        // // Display the result
        // if (intersectionNode != null) {
        //     System.out.println("Intersection Node Value: " + intersectionNode_brute.val);
        // } else {
        //     System.out.println("No Intersection Found");
        // }
    }
}
