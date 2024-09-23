import java.util.*;

class Solution {

  List<String> ans = new ArrayList<>();
  StringBuilder SB = new StringBuilder();
  String[] map = {
    "",
    "",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz",
  };

  public List<String> letterCombinations(String digits) {
    combination(digits, 0);
    return ans;
  }

  public void combination(String digits, int index) {
    if (SB.length() == digits.length()) {
      ans.add(SB.toString());
      return;
    }
    if (digits.length() == 0) {
      return;
    }
    String str = map[digits.charAt(index) - '0'];
    for (int i = 0; i < str.length(); i++) {
      SB.append(str.charAt(i));
      combination(digits, index + 1);
      SB.deleteCharAt(SB.length() - 1);
    }
  }
}
