class Solution {

  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int num : stones) {
      sum += num;
    }
    int target = sum / 2;
    int[][] dp = new int[stones.length + 1][target + 1];
    for (int i = 1; i <= stones.length; i++) {
      for (int j = 1; j <= target; j++) {
        if (j < stones[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] =
            Math.max(
              dp[i - 1][j],
              dp[i - 1][j - stones[i - 1]] + stones[i - 1]
            );
        }
      }
    }
    return sum - 2 * dp[stones.length][target];
  }
}
