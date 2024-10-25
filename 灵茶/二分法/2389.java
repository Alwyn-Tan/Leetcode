import java.util.*;

class Solution {

  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int[] sums = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }

    for (int i = 0; i < queries.length; i++) {
      int l = 0;
      int r = sums.length;
      while (l < r) {
        int mid = (l + r) / 2;

        if (sums[mid] <= queries[i]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      queries[i] = l - 1;
    }
    return queries;
  }
}
