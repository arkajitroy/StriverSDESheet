package LinkedLists_Arrays;

class Main {

    public static int trap(int[] height){
        int n = height.length;
        int trappedWater = 0;

        if (n <= 2) {
            return trappedWater;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Calculate the maximum height on the left for each position
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate the maximum height on the right for each position
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water for each position
        for (int i = 1; i < n - 1; i++) {
            int currentTrap = Math.max(0, Math.min(leftMax[i - 1], rightMax[i + 1]) - height[i]);
            trappedWater += currentTrap;
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = trap(height);

        System.out.println("Trapped Water: " + trappedWater);
    }
}
