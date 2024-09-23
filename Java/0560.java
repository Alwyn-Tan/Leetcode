import java.util.*;

class Solution {

  public int subarraySum(int[] nums, int k) {
    int[] sum = new int[nums.length + 1];
    Set<Integer> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
      if (i >= 1) {
        set.add(sum[i]);
      }
    }
    for (int i = 0; i < sum.length; i++) {
      if (set.contains(k + sum[i])) {
        count++;
      }
    }
    return count;
  }
}
