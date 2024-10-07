class Solution {

  public int equalSubstring(String s, String t, int maxCost) {
    int right = 0;
    int left = 0;
    int ans = 0;
    int cost = 0;
    while (right < s.length()) {
      cost += Math.abs(s.charAt(right) - t.charAt(right));
      while (cost > maxCost) {
        cost -= Math.abs(s.charAt(left) - t.charAt(left));
        left++;
      }
      ans = Math.max(ans, right - left + 1);
      right++;
    }
    return ans;
  }
}
