import java.util.*;

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long max = 0;
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);

            if (map.size() >= m) {
                max = Math.max(max, sum);
            }
            if (i >= k - 1) {
                sum -= nums.get(i - k + 1);
                map.computeIfPresent(nums.get(i - k + 1), (key, value) -> value - 1 == 0 ? null : value - 1);
            }
        }
        return max;
    }
}