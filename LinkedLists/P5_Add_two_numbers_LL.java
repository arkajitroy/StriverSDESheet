package LinkedLists;

class Solution {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int value){
            this.val = value;
        }
    }

    // ========================================= Recursive Solution ===================================
    public ListNode addTwoNumbers_recursion(ListNode list1, ListNode list2){
        return recursionHelper(list1, list2, 0);
    }

    public ListNode recursionHelper(ListNode list1, ListNode list2, int carry){
        if(list1 == null && list2 == null && carry == 0) return null;

        // extract values from current nodes (if available)
        int value_1 = (list1 != null) ? list1.val : 0;
        int value_2 = (list2 != null) ? list2.val : 0;

        // calculate the sum
        int sum = value_1 + value_2 + carry;
        int newCarry = sum / 10;

        // creating a new list for result
        ListNode result = new ListNode(sum % 10);

        // recursive call for the next node
        ListNode next_node_list_1 = (list1 != null) ? list1.next : null;
        ListNode next_node_list_2 = (list2 != null) ? list2.next : null;

        result.next = recursionHelper(next_node_list_1, next_node_list_2, newCarry);

        return result;
    }

    // ================================================= Dummy Node Itterative Solution =============================

    public ListNode addTwoNumbers(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int sum = carry;
            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }

            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }

            carry = sum / 10;
            int remainder = sum % 10;
            current.next = new ListNode(remainder);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example linked lists
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Call the addTwoNumbers function
        ListNode result = solution.addTwoNumbers_recursion(l1, l2);

        // Print the result linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
