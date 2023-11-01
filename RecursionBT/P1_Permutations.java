package RecursionBT;

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int first, List<List<Integer>> result) {
        if (first == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = first; i < nums.length; i++) {
            // Swap the elements at positions 'first' and 'i'
            int temp = nums[first];
            nums[first] = nums[i];
            nums[i] = temp;

            // Recursively generate permutations for the remaining elements
            backtrack(nums, first + 1, result);

            // Undo the swap to backtrack and explore other possibilities
            temp = nums[first];
            nums[first] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
