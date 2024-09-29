class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            answer = Math.max(answer, sum);
            sum -= nums[i - k + 1];
        }
        return answer / k;
    }
}