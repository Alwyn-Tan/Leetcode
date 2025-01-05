class Solution {
    public int numberOfWays(int n, int x) {
        long [] dp = new long [n + 1];
        dp[0] = 1;
        for(int i=1; Math.pow(i ,x) <= n; i++){
            for(int j =n ;j >= Math.pow(i, x); j--){
                dp[j] = dp[j] + dp[j - (int) Math.pow(i, x)];
            }
        }
        return (int) (dp[n] % 1_000_000_007);
    }
}