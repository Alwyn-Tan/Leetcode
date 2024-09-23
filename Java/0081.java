import java.util.*;

class Solution {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtracking(candidates, target, 0, 0);
    return res;
  }

  public void backtracking(
    int[] candidates,
    int target,
    int sum,
    int startIndex
  ) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      path.add(candidates[i]);
      backtracking(candidates, target, sum + candidates[i], i);
      path.remove(path.size() - 1);
    }
  }
}
