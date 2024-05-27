package Arrays_II;

class Main {
    // using XOR - O(n) | O(1)
    public static int[] missingRepeating(int[] nums, int n){
        int xor = 0;

        // find xor of all the elements
        for(int i=0; i<n; i++){
            xor = xor ^ nums[i];
            xor = xor ^ (i+1);
        }

        // find the differentiating bit-number
        int number = (xor & ~(xor - 1));

        int zero = 0, one = 0;
        for(int i=0; i<n; i++){
            // part-1 group
            if((nums[i] & number) != 0) one = one ^ nums[i];
            else zero = zero ^ nums[i];
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) one = one ^ i;
            //part of 0 group:
            else zero = zero ^ i;
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }

    // better approach - O(n) | O(n)
    public static int[] missingRepeating_better(int[] nums, int n){
        int[] hash = new int[n+1];
        int missing = -1, repeating = -1;

        // updating the hash array with | 0 : if not present | 1 : if present | 2 : duplicates
        for(int i=0; i<n; i++){
            hash[nums[i]]++;
        }

        // iterate and find the missing and repeating
        for(int i=1; i<=n; i++){
            if(hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if(repeating != -1 && missing != -1) break;
        }

        return new int[]{ repeating, missing };
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 3};
        int result[] = missingRepeating(nums, nums.length);
        System.out.println("Repeating Number : " +result[0]+" - Missing Number : "+result[1]);
    }
}
