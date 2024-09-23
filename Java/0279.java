class Solution {

  public int numSquares(int n) {
    int root = (int) Math.sqrt(n);
    int[] nums = new int[root];
    for (int i = 1; i <= root; i++) {
      nums[i - 1] = i * i;
    }
    int[] dp = new int[n + 1];
    for (int j = 1; j <= n; j++) {
      dp[j] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j <= n; j++) {
        if (j >= nums[i]) {
          dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
        }
      }
    }
    return dp[n];
  }
}
