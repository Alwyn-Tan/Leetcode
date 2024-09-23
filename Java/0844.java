/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty. */
class Solution {

  public boolean backspaceCompare(String s, String t) {
    int ss = 0, sq = 0, ts = 0, tq = 0;
    while (sq < s.length()) {
      if (s.charAt(sq) == '#') {
        ss--;
      } else {
        s[ss] = s.charAt(sq);
      }
    }
  }
}
