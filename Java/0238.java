class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length + 1];
        int[] suf = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) {
                pre[i] = nums[0];
            } else {
                pre[i] = pre[i - 1] * nums[i];
            }
        }
        for (int i = nums.length; i >= 0; i++) {
            if (i == nums.length) {
                suf[i] = nums[0];
            } else {
                suf[i] = suf[i + 1] * nums[i];
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] * suf[nums.length - i];
        }
        return ans;
    }
}