package Arrays_II;
import java.util.*;

class Solution {

    // Sorting the array and then find the duplicate - O(n log n + n)
    public static int findDuplicate_brute(int[] nums) {
        Arrays.sort(nums);

        // Step 2: Iterate through the sorted array to find the duplicate
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // using hashset - O(n)
    public static int findDuplicate_better(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num; // Found the duplicate
            }
            seen.add(num);
        }
        return -1;
    }

    // using tortoise and hare algo - O(n) - optimised
    public static int findDuplicate(int[] nums) {
        // Initialize tortoise and hare
        int tortoise = nums[0];
        int hare = nums[0];

        // Phase 1: Find the intersection point of the two pointers
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Find the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // The meeting point is the duplicate number
        return tortoise;
    }



    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};

        int result = findDuplicate_brute(nums);
        System.out.println("Duplicate Number: " + result);
    }
}
