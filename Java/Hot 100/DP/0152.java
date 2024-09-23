class Solution {

  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int cmax = 1;
    int cmin = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = cmax;
        cmax = cmin;
        cmin = temp;
      }

      cmax = Math.max(nums[i], cmax * nums[i]);
      cmin = Math.min(nums[i], cmin * nums[i]);

      max = Math.max(max, cmax);
    }
    return max;
  }
}
