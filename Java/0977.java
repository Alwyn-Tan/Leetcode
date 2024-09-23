//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
class Solution {

  public int[] sortedSquares(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int result[] = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[left] * nums[left] < nums[right] * nums[right]) {
        result[i] = nums[right] * nums[right];
        right--;
      } else {
        result[i] = nums[left] * nums[left];
        left++;
      }
    }
    return result;
  }
}
