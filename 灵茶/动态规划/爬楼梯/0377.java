import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] d = new int[target + 1];
        Arrays.sort(nums);
        d[0] = 1;
        for (int i = nums[0]; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    d[i] += d[i - num];
                }
            }
        }
        return d[target];
    }
}