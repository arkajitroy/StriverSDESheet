package Arrays_IV;

import java.util.*;

class Solution {
    public static int[] twoSums_HashMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complementary = target-nums[i];

            if(map.containsKey(complementary)){
                return new int[]{
                    map.get(complementary), i
                };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSums_TwoPointer(int[] nums, int target){
        Arrays.sort(nums);

        int left_pt = 0, right_pt = nums.length-1;

        while(left_pt < right_pt){
            int sum = nums[left_pt] + nums[right_pt];

            if(sum == target) return new int[]{ left_pt, right_pt };
            else if(sum < target) left_pt++;
            else right_pt--;
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,13};
        int target = 9;

        int[] result_mp= twoSums_HashMap(nums, target);
        int[] result_twoPt= twoSums_TwoPointer(nums, target);

        System.out.println("Hashmap output:"+Arrays.toString(result_mp));
        System.out.println("Two Pointer output:"+Arrays.toString(result_twoPt));

    }
}
