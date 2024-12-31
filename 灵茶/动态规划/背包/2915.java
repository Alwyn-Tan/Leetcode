import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum = Math.min(sum + nums.get(i), target);
            for (int j = sum; j >= nums.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - nums.get(i)] + 1);
            }
        }
        int ans = dp[target];
        return ans < 0 ? -1 : ans;
    }
}