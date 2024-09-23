import java.util.*;

class Solution {

  List<Integer> path = new ArrayList<>();
  int count = 4;

  public boolean makesquare(int[] matchsticks) {
    int sum = 0;
    for (int num : matchsticks) {
      sum += num;
    }
    if (sum % 4 != 0) {
      return false;
    }
    int target = sum / 4;

    Arrays.sort(matchsticks);
    backtrack(matchsticks, target, 0, 0);
    return count <= 0;
  }

  public void backtrack(int[] matchsticks, int target, int start, int sum) {
    if (sum == target) {
      count--;
      return;
    }
    if (sum > target) {
      return;
    }
    for (int i = start; i < matchsticks.length; i++) {
      if (sum + matchsticks[i] > target) {
        continue;
      }
      path.add(matchsticks[i]);
      backtrack(matchsticks, target, i + 1, sum + matchsticks[i]);
      path.remove(path.size() - 1);
      //sum -= matchsticks[i];
    }
  }
}
