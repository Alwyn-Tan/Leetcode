class Solution {

  public int longestSemiRepetitiveSubstring(String s) {
    int ans = 1;
    int right = 1;
    int left = 0;
    int same = 0;
    while (right < s.length()) {
      if (s.charAt(right) == s.charAt(right - 1)) {
        same++;
      }
      if (s.charAt(right) == s.charAt(right - 1) && same >= 2) {
        left++;
        while (s.charAt(left) != s.charAt(left - 1)) {
          left++;
        }
        same--;
      }
      ans = Math.max(ans, right - left + 1);
      right++;
    }
    return ans;
  }
}
