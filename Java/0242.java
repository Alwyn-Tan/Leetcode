class Solution {

  public boolean isAnagram(String s, String t) {
    int[] list = new int[26];
    if (s.length() != t.length()) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      list[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      list[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < list.length; i++) {
      if (list[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
