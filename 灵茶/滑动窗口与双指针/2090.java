class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        Long sum = 0L;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= 2 * k) {
                result[i - k] = (int) (sum / (2 * k + 1));
                sum -= nums[i - 2 * k];
            }
            result[i] = -1;
        }
        return result;
    }
}