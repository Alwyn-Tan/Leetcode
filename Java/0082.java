import java.util.*;

class Solution {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtrack(candidates, target, 0, 0);
    return res;
  }

  public void backtrack(int[] candidates, int target, int sum, int startIndex) {
    if (sum == target) {
      res.add(new ArrayList<>(path));
      return;
    }
    if (sum > target) {
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      if (i > startIndex && candidates[i] == candidates[i - 1]) {
        continue;
      }
      path.add(candidates[i]);
      backtrack(candidates, target, sum + candidates[i], i + 1);
      path.remove(path.size() - 1);
    }
  }
}
