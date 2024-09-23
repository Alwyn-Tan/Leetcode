import java.util.*;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      if (i >= k && deque.getFirst() == nums[i - k]) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && deque.getLast() <= nums[i]) {
        deque.removeLast();
      }

      deque.addLast(nums[i]);

      if (i >= k - 1) {
        ans[i - k + 1] = deque.getFirst();
      }
    }
    return ans;
  }
}
