import java.util.*;

class Solution {

  List<List<Integer>> ans = new ArrayList<>();
  List<Integer> com = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtrack(candidates, target, 0, 0);
    return ans;
  }

  public void backtrack(int[] candidates, int target, int start, int sum) {
    if (sum == target) {
      ans.add(new ArrayList<>(com));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (sum + candidates[i] > target) {
        continue;
      }
      com.add(candidates[i]);
      backtrack(candidates, target, i, sum + candidates[i]);
      com.remove(com.size() - 1);
    }
  }
}
