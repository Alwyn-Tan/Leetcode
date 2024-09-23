/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity. */
class Solution {

  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    int middle = 0;
    while (left < right) {
      middle = (left + right) / 2;
      if (nums[middle] > target) {
        right = middle;
      } else if (nums[middle] == target) {
        return middle;
      } else {
        left = middle + 1;
      }
    }
    return right;
  }
}
