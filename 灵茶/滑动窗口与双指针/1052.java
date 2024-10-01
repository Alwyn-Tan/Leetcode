class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            ans += (1 - grumpy[i]) * customers[i];
        }
        int gain = 0;
        int maxGain = 0;
        for (int left = 0, right = 0; right < customers.length; right++) {
            gain += (grumpy[right] * customers[right]);
            maxGain = Math.max(maxGain, gain);
            if (right - left >= minutes - 1) {
                gain -= (grumpy[left] * customers[left]);
                left++;
            }
        }
        return ans + maxGain;
    }
}