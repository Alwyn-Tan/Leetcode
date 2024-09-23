import java.util.*;

class Solution {

  List<String> res = new ArrayList<>();
  StringBuilder SB = new StringBuilder();

  public List<String> generateParenthesis(int n) {
    backtrack(n, 0, 0);
    return res;
  }

  public void backtrack(int n, int left, int right) {
    if (left > n || right > n || right > left) {
      return;
    }
    if (SB.length() == n * 2) {
      res.add(SB.toString());
      return;
    }
    for (int i = 0; i < 2; i++) {
      if (i == 0) {
        SB.append("(");
        backtrack(n, left + 1, right);
        SB.deleteCharAt(SB.length() - 1);
      } else {
        SB.append(")");
        backtrack(n, left, right + 1);
        SB.deleteCharAt(SB.length() - 1);
      }
    }
  }
}
