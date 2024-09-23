import java.util.*;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    int[] count = new int[26];
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < p.length(); i++) {
      count[p.charAt(i) - 'a']++;
    }
    for (int right = 0, left = 0; right < s.length(); right++) {
      count[s.charAt(right) - 'a']--;
      if (count[s.charAt(right) - 'a'] < 0) {
        count[s.charAt(left) - 'a']++;
        left++;
      }
      if (right - left + 1 == p.length()) {
        res.add(left);
      }
    }
    return res;
  }
}
