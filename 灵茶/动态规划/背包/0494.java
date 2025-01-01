import java.util.Map;

class Solution {
    Map<String, Integer> cache = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int index, int sum) {
        String key = index + "_" + sum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (index == nums.length) {
            cache.put(key, sum == target ? 1 : 0);
            return cache.get(key);
        }
        int left = dfs(nums, target, index + 1, sum + nums[index]);
        int right = dfs(nums, target, index + 1, sum - nums[index]);
        cache.put(key, left + right);
        return cache.get(key);
    }
}