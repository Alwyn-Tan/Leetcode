class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int minprice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
            minprice = Math.min(minprice, prices[i]);
        }
        return dp[prices.length - 1];
    }
}