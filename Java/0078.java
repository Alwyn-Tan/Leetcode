import java.util.*;
import java.util.prefs.BackingStoreException;

class Solution {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    for (int i = 0; i <= nums.length; i++) {
      backtrack(nums, i, 0);
    }
    return res;
  }

  public void backtrack(int[] nums, int k, int startIndex) {
    if (k == path.size()) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i < nums.length; i++) {
      path.add(nums[i]);
      backtrack(nums, k, i + 1);
      path.remove(path.size() - 1);
    }
  }
}
