class Solution {

  public int findLengthOfLCIS(int[] nums) {
    int result[] = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        result[i] = result[i - 1] + 1;
      } else {
        result[i] = 1;
      }
    }
    int max = result[0];
    for (int i = 1; i < result.length; i++) {
      if (result[i] > max) {
        max = result[i];
      }
    }
    return max;
  }
}
