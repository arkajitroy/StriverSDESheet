package Arrays_II;

// Find the duplicate in an array of N+1 integer

class Main {
    // optimal approach - O(n) | O(1)
    private static int findDuplicate(int[] nums){
        int slow = nums[0], fast = nums[0];

        // creating the cycle
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        // now finding the intersecting point
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // better appraoch - O(n) | O(n)
    private static int findDuplicate_better(int[] nums){
        int[] freq = new int[nums.length + 1];
        for(int num : nums){
            if(freq[num] == 0) freq[num] += 1;
            else return num;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 7, 9, 10, 15, 10, 3 };
        System.out.println("Duplicate Number - (better) : " + findDuplicate_better(nums));
        System.out.println("Duplicate Number - (Optimal) : " + findDuplicate(nums));
    }
}
