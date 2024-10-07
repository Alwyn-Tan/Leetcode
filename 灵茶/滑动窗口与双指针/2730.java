class Solution {

  public int longestSemiRepetitiveSubstring(String s) {
    if (s.length() <= 2) {
      return s.length();
    }
    int right = 2;
    int left = 0;
    int ans = 2;
    boolean couple = false;
    while (right < s.length()) {
      if (s.charAt(0) == s.charAt(1)) {
        couple = true;
      }
      if (s.charAt(right - 1) == s.charAt(right - 1) && couple) {
        left = right;
        couple = false;
      }
      ans = Math.max(ans, right - left + 1);
      right++;
    }
    return ans;
  }
}
