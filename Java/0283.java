/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array. */
class Solution {

  public void moveZeroes(int[] nums) {
    int quick = 0;
    int slow = 0;
    while (quick < nums.length) {
      if (nums[quick] != 0) {
        nums[slow] = nums[quick];
        slow++;
      }
      quick++;
    }
    for (int i = slow; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
