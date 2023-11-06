package LinkedLists_Arrays;

class Solution{
    public static int findMaxConsecutiveOnes(int[] nums ){
        int maxi = 0, count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxi = Math.max(maxi, count);
            }else{
                count = 0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }
}