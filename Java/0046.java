import java.util.*;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    backtrack(nums);
    return res;
  }

  public void backtrack(int[] nums) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
    }
    for (int i = 0; i < nums.length; i++) {
      if (path.contains(nums[i])) {
        continue;
      }
      path.add(nums[i]);
      backtrack(nums);
      path.remove(path.size() - 1);
    }
  }
}