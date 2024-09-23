package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// Approach-1 : Merge All Nodes into a array and sort
// * Time Complexity: O(n) + O(n log n) + O(n) = O(n log n) { collecting, sorting and rebuilding }
// ? Space Complexity: O(n) + O(n) = O(2n) { listing, output }

class BruteForce {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> values = new ArrayList<>();
        
        // Collect all nodes into a list
        for (ListNode list : lists) {
            while (list != null) {
                values.add(list.val);
                list = list.next;
            }
        }
        
        // Sort all the collected values
        Collections.sort(values);
        
        // Build the result linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
}

// Appraoch 02 : Merge Two List at a time
// * Time Complexity : O(k-1) + O(n) = O(k*n) { computing k lists , merge list }
// ? Space Complexity : O(log k) { recursive depth of tree }

class Better {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}

// Approach 3: Using Priority Queue
// * Time Complexity : O(k-1) + O(n) = O(k*n) { computing k lists , merge list }
// ? Space Complexity : O(log k) { recursive depth of tree }

class Optimal {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all list heads to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract minimum from the heap and add the next node from that list to the heap
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}

class P5_merge_K_sorted_array {
    public static void main(String[] args) {
        // Example usage
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        BruteForce brute = new BruteForce();
        Better better = new Better();
        Optimal optimal = new Optimal();

        ListNode result1 = brute.mergeKLists(lists);
        ListNode result2 = better.mergeKLists(lists);
        ListNode result3 = optimal.mergeKLists(lists);
        
        // Print merged list
        // while (result != null) {
        //     System.out.print(result.val + " ");
        //     result = result.next;
        // }
    }
}