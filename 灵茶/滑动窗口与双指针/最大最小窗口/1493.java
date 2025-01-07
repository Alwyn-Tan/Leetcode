class Solution {

  public int longestSubarray(int[] nums) {
    int left = 0;
    int right = 0;
    int ans = 0;
    int zeros = 0;
    while (right < nums.length) {
      if (nums[right] == 0) {
        zeros++;
      }
      while (zeros > 1) {
        if (nums[left] == 0) {
          zeros--;
        }
        left++;
      }
      ans = Math.max(ans, right - left);
      right++;
    }
    return ans;
  }
}
