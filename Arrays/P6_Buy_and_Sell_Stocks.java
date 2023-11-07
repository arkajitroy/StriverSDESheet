package Arrays;

class Solution{

    // Greedy Approach - recommended
    public static int maxProfit_greedy(int[] prices){
        if(prices == null || prices.length <= 1) return 0;

        int minPrice = prices[0], maxProfit = 0, cost = 0;

        for(int i=1; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            cost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
        }

        return maxProfit;
    }

    // Dynamic programming
    public static int maxProfit_DP(int[] prices){
        if(prices == null || prices.length <= 1) return 0;

        int cost = 0, n = prices.length;
        int[] minPrice = new int[n], maxProfit = new int[n];
        

        // assigning initial values
        minPrice[0] = prices[0];
        maxProfit[0] = 0;

        for(int i=1; i<prices.length; i++){
            minPrice[i] = Math.min(minPrice[i-1], prices[i]);
            cost = prices[i] - minPrice[i-1];
            maxProfit[i] = Math.max(maxProfit[i-1], cost);
        }

        return maxProfit[n - 1];
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit_greedy(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}