import java.util.Arrays;

class Solution {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j >= coins[i]) {
          if (dp[j - coins[i]] != Integer.MAX_VALUE) {
            dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
          }
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
