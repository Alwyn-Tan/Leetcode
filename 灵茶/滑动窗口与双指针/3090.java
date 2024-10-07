import java.util.*;

class Solution {

  public int maximumLengthSubstring(String s) {
    int ans = 0;
    int left = 0;
    int right = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (right < s.length()) {
      while (map.getOrDefault(s.charAt(right), 0) >= 2) {
        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        left++;
      }
      map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
      ans = Math.max(ans, right - left + 1);
      right++;
    }
    return ans;
  }
}
