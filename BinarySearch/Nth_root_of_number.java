package BinarySearch;

class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        if (m == 0) return 0;
        if (n == 1) return m;

        long left = 1;
        long right = m;
        long result = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long midNthPower = (long) Math.pow(mid, n);

            if (midNthPower == m) {
                return (int) mid;
            } else if (midNthPower < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int n = 2; // The root (e.g., square root)
        int m = 16; // The number to find the nth root of

        int result = NthRoot(n, m);
        System.out.println("The " + n + "th root of " + m + " is: " + result);
    }
}
