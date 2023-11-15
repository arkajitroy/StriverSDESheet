package Heap;
import java.util.PriorityQueue;


class Solution{
    // using min-heap 
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 2, 5};
        int k = 3;

        int result = findKthLargest(nums, k);

        System.out.println("The " + k + "th largest element is: " + result);
    }
}