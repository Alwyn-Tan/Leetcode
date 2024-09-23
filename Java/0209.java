import java.util.*;

class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = 0;
    int result = Integer.MAX_VALUE;
    int sum = 0;
    while (right < nums.length) {
      sum += nums[right];
      right++;
      while (sum >= target) {
        result = Math.min(result, right - left);
        sum -= nums[left];
        left++;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}