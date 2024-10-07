
import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i >= k - 1) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }
                sum -= nums[i - k + 1];
                map.computeIfPresent(nums[i - k + 1], (key, value) -> value - 1 == 0 ? null : value - 1);
            }
        }
        return ans;
    }
}