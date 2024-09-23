import java.util.*;

class Solution {

  List<String> res = new ArrayList<>();
  StringBuilder SB = new StringBuilder();
  String[] nums = {
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
    if (digits.length() == 0) {
      return res;
    }
    backtrack(digits, 0);
    return res;
  }

  public void backtrack(String digits, int index) {
    if (SB.length() == digits.length()) {
      res.add(SB.toString());
      return;
    }
    String str = nums[digits.charAt(index) - '0'];
    for (int i = 0; i < str.length(); i++) {
      SB.append(str.charAt(i));
      backtrack(digits, index + 1);
      SB.deleteCharAt(SB.length() - 1);
    }
  }
}
