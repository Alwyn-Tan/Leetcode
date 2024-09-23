import java.util.*;

class Solution {

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> subList = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    backtrack(n, k, 1);
    return result;
  }

  public void backtrack(int n, int k, int start) {
    if (subList.size() == k) {
      result.add(new ArrayList<>(subList));
      return;
    }
    for (int i = start; i <= n; i++) {
      subList.add(i);
      backtrack(4, 2, i + 1);
      subList.remove(subList.size() - 1);
    }
  }
}
