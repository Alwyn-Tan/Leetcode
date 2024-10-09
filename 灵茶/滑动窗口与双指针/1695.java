import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet();
        int sum = 0;
        int ans = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += nums[right];
            set.add(nums[right]);
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }
}