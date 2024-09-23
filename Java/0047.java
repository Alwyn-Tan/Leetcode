import java.util.*;

class Solution {

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> arr = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    int[] used = new int[nums.length];
    backtrack(nums, used);
    return result;
  }

  public void backtrack(int[] nums, int[] used) {
    if (arr.size() == nums.length) {
      result.add(new ArrayList<>(arr));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
        continue;
      }
      if (used[i] == 0) {
        arr.add(nums[i]);
        used[i] = 1;
        backtrack(nums, used);
        arr.remove(arr.size() - 1);
        used[i] = 0;
      }
    }
  }
}
