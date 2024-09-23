import java.util.*;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new LinkedList<>();
    int[] ans = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
        dq.removeLast();
      }
      dq.addLast(i);
      if (i - dq.getFirst() >= k) {
        dq.removeFirst();
      }
      if (i >= k - 1) {
        ans[i - k + 1] = nums[dq.getFirst()];
      }
    }
    return ans;
  }
}
