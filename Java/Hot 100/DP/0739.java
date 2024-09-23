class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        dp[dp.length - 1] = 0;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    dp[i] = j - i;
                    break;
                } else if (dp[j] == 0) {
                    dp[i] = 0;
                    break;
                }
            }
        }
        return dp;
    }
}