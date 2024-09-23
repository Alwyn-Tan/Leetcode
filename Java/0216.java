import java.util.*;

class Solution {

  List<Integer> subList = new ArrayList<>();
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    backtrack(k, n, 1);
    return ans;
  }

  public void backtrack(int k, int n, int start) {
    if (subList.size() == k && n == 0) {
      ans.add(new ArrayList<>(subList));
      return;
    }
    for (int i = start; i <= 9; i++) {
      if (n - i < 0) {
        break;
      }
      subList.add(i);
      backtrack(k, n - i, i + 1);
      subList.remove(subList.size() - 1);
    }
  }
}
