import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.get(nums[right]) > k) {
                map.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}