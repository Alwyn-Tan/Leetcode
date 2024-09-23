import java.util.*;

class Solution {

  public int getSum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += (n % 10) * (n % 10);
      n = n / 10;
    }
    return sum;
  }

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (!set.contains(getSum(n))) {
      n = getSum(n);
      if (n == 1) {
        return true;
      }
      set.add(n);
    }
    return false;
  }
}
