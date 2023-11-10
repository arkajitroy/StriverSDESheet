package Recurssion;
import java.util.*;

class Solution {
    // USING RECUSSION
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumsHelper(arr, N, 0, 0, result);
        return result;
    }

    private static void subsetSumsHelper(ArrayList<Integer> arr, int N, int currIdx, int currSum, ArrayList<Integer> result){
        if(currIdx == N){
            result.add(currSum);
            return;
        }

        subsetSumsHelper(arr, N, currIdx+1, currSum+arr.get(currIdx), result);
        subsetSumsHelper(arr, N, currIdx+1, currSum, result);
    }

    // USING DP
    public static ArrayList<Integer> subsetSumsDP(ArrayList<Integer> arr, int N) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        boolean[][] dp = new boolean[N + 1][sum + 1];

        // Base case
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr.get(i - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr.get(i - 1)];
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 1; j <= sum; j++) {
            if (dp[N][j]) {
                result.add(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(5);
        int N = arr.size();

        ArrayList<Integer> result = subsetSums(arr, N);

        System.out.println("Subsets with target sum:");
        System.out.println(result);
    }    
}
