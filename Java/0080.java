import java.util.*;

class Solution {

  List<Integer> path = new ArrayList<>();
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    backtrack(n, k, 1);
    return ans;
  }

  public void backtrack(int n, int k, int start) {
    if (path.size() == k) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (int i = start; i <= n; i++) {
      path.add(i);
      backtrack(n, k, i + 1);
      path.remove(path.size() - 1);
    }
  }
}
