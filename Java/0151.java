import java.util.*;

class Solution {

  private StringBuilder removeSpace(String s) {
    StringBuilder sb = new StringBuilder();
    int l = 0;
    int r = s.length() - 1;
    while (s.charAt(l) == ' ') {
      l++;
    }
    while (s.charAt(r) == ' ') {
      r--;
    }
    while (l <= r) {
      if (s.charAt(l) != ' ') {
        sb.append(s.charAt(l));
      } else if (s.charAt(l + 1) != ' ') {
        sb.append(' ');
      }
      l++;
    }
    //System.out.println(sb.toString());
    return sb;
  }

  public void reverse(int l, int r, StringBuilder s) {
    while (l < r) {
      char temp = s.charAt(l);
      s.setCharAt(l, s.charAt(r));
      s.setCharAt(r, temp);
      l++;
      r--;
    }
  }

  public String reverseWords(String s) {
    StringBuilder sb = removeSpace(s);
    StringBuilder after_reverse = sb.reverse();
    System.out.println(after_reverse);
    int l = 0;
    int r = 0;
    while (l < after_reverse.length()) {
      while (r < after_reverse.length() && after_reverse.charAt(r) != ' ') {
        r++;
      }
      reverse(l, r - 1, after_reverse);
      l = r + 1;
      r = l + 1;
    }
    System.out.println(after_reverse);
    return after_reverse.toString();
  }

  public static void main(String args[]) {
    String s = "   the  sky is      blue";
    Solution solution = new Solution();
    solution.reverseWords(s);
  }
}
