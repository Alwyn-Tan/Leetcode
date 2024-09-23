import java.util.*;

class Solution {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtrack(nums, 0);
    return res;
  }

  public void backtrack(int[] nums, int start) {
    res.add(new ArrayList<>(path));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i - 1] == nums[i]) {
        continue;
      }
      path.add(nums[i]);
      backtrack(nums, i + 1);
      path.remove(path.size() - 1);
    }
  }
}
