//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

//You must write an algorithm with O(log n) runtime complexity.
class Solution {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    int middle = 0;
    while (left < right) {
      middle = (left + right) / 2;
      if (target > nums[middle]) {
        left = middle + 1;
      } else if (target == nums[middle]) {
        return middle;
      } else {
        right = middle;
      }
    }
    return -1;
  }
}
