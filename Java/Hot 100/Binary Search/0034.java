class Solution {

  public int[] searchRange(int[] nums, int target) {
    return new int[] { findLeft(nums, target), findRight(nums, target) };
  }

  public int findLeft(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        if (mid == 0 || nums[mid - 1] != target) {
          return mid;
        } else {
          right = mid;
        }
      }
    }
    return -1;
  }

  public int findRight(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        if (mid == nums.length - 1 || nums[mid + 1] != target) {
          return mid;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }
}
