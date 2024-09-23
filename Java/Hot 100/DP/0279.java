import java.util.*;

class Solution {

  public int numSquares(int n) {
    int root = (int) Math.sqrt(n);
    int[] nums = new int[root];
    for (int i = 0; i < root; i++) {
      nums[i] = (i + 1) * (i + 1);
    }

    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
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
