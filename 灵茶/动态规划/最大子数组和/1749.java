class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = Math.abs(nums[0]);
        int[] max_dp = new int[nums.length];
        int[] min_dp = new int[nums.length];
        max_dp[0] = nums[0];
        min_dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_dp[i] = Math.max(max_dp[i - 1] + nums[i], nums[i]);
            min_dp[i] = Math.min(min_dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(Math.abs(max_dp[i]), Math.abs(min_dp[i])));
        }
        return ans;
    }
}