package DynamicProgramming;

class Solution {

    public static int maxProductSubarray(int []arr){
        int size = arr.length;

        int pref = 1, suff = 1, result = Integer.MIN_VALUE;

        for(int i=0; i<size; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref = pref * arr[i];
            suff = suff * arr[size - i - 1];

            result = Math.max(result, Math.max(pref, suff));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,-3,0,-4,-5 };
        int result = maxProductSubarray(arr);
        System.out.println("The Maximum Product Subarray"+ result);
    }
}
