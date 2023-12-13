package Arrays_IV;

import java.util.*;

class Main {
    public static List<List<Integer>> fourSumBrute(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                for(int k=j+1; k<nums.length-1; k++){
                    for(int l=k+1; l<nums.length; l++){
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];

                        if(sum == target){
                            List<Integer> quadPair = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            result.add(quadPair);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int currSum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (currSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (currSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Using a map to store pairs of elements and their sums
        Map<Integer, List<int[]>> pairSums = new HashMap<>();

        // Fix the first two elements
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int complement = target - sum;

                // Check if complement exists in the map
                if (pairSums.containsKey(complement)) {
                    for (int[] pair : pairSums.get(complement)) {
                        int third = pair[0];
                        int fourth = pair[1];

                        // Ensure there are no duplicate elements
                        if (j < third) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[third], nums[fourth]));
                        }
                    }
                }
            }

            // Update the map with the current pair
            for (int k = 0; k < i; k++) {
                int currentSum = nums[k] + nums[i];
                pairSums.computeIfAbsent(currentSum, key -> new ArrayList<>()).add(new int[]{k, i});
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result_brute = fourSumBrute(nums, target);
        List<List<Integer>> result_better = fourSumBetter(nums, target);
        List<List<Integer>> result_optimal = fourSumOptimal(nums, target);
    }
}
