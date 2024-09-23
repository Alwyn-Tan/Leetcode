import java.util.*;

class Solution {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public void backtrack(int[] candidates, int target, int index) {
    if (target == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (target < 0) {
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if(i > index && candidates[i] == candidates[i - 1]){
        continue;
      }
      temp.add(candidates[i]);
      backtrack(candidates, target - candidates[i], i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtrack(candidates, target, 0);
    return res;
  }
}
