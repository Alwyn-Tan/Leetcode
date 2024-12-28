class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] d = new int[cost.length + 1];
        for (int i = 2; i < d.length; i++) {
            d[i] = Math.min(d[i - 1] + cost[i - 1], d[i - 2] + cost[i - 2]);
        }
        return d[cost.length];
    }
}