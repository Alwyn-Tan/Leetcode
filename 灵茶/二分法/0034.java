class Solution {

    public int[] searchRange(int[] nums, int target) {
        int start = findBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { start, findBound(nums, target + 1) - 1 };
        }
    }

    public int findBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}