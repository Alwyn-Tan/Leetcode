class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int max = 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            map[chars.charAt(i) - 'a'] = vals[i];
        }
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Math.max(dp[i - 1] + map[s.charAt(i - 1) - 'a'], map[s.charAt(i - 1) - 'a']);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}