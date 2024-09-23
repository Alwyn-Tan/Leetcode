class Solution {

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    int[][] dp = new int[nums.length + 1][target + 1];
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= target; j++) {
        if (j < nums[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
        }
      }
    }
    return dp[nums.length][target] == target;
  }
}

class Soluttion {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int i = 0; i < nums.length; i++) {
      for (int j = target; j >= nums[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
      }
    }
    return dp[target] == target;
  }
}
