class Solution {
    public void moveZeroes(int[] nums) {
        int q = 0;
        int s = 0;
        while (q < nums.length) {
            if (nums[q] != 0) {
                nums[s] = nums[q];
                s++;
            }
            q++;
        }
        for (int i = s; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}