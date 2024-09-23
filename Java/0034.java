/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity. */
class Solution {

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    int middle = 0;
    while (left < right) {
      middle = (left + right) / 2;
      if (nums[middle] < target) {
        left = middle + 1;
      } else if (nums[middle] > target) {
        right = middle;
      } else if (nums[middle] != target) {
        break;
      } else {
        int leftBound;
        int rightBound;
        if (findLB(nums, target, left, middle) == -1) {
          leftBound = middle;
        } else {
          leftBound = findLB(nums, target, left, middle);
        }
        if (findRB(nums, target, middle + 1, right) == -1) {
          rightBound = middle;
        } else {
          rightBound = findRB(nums, target, middle + 1, right);
        }
        return new int[] { leftBound, rightBound };
      }
    }
    return new int[] { -1, -1 };
  }

  public int findLB(int[] nums, int target, int left, int right) {
    while (left < right) {
      int middle = (left + right) / 2;
      if (target > nums[middle]) {
        left = middle + 1;
      } else if (target < nums[middle]) {
        right = middle;
      } else if (nums[middle] == target) {
        if (findLB(nums, target, left, middle) != -1) {
          return findLB(nums, target, left, middle);
        } else {
          return middle;
        }
      }
    }
    return -1;
  }

  public int findRB(int[] nums, int target, int left, int right) {
    while (left < right) {
      int middle = (left + right) / 2;
      if (target > nums[middle]) {
        left = middle + 1;
      } else if (target < nums[middle]) {
        right = middle;
      } else if (nums[middle] == target) {
        if (findRB(nums, target, middle + 1, right) != -1) {
          return findRB(nums, target, middle + 1, right);
        } else {
          return middle;
        }
      }
    }
    return -1;
  }
}
