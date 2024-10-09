import java.util.*;

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int[] arr = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(arr);
            if (arr[x - 1] < 0) {
                ans[i] = arr[x - 1];
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}