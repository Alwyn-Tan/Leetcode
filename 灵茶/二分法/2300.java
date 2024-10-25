import java.util.*;

class Solution {

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] ans = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i++) {
      ans[i] = potions.length - upperBound(potions, spells[i], success);
    }
    return ans;
  }

  public int upperBound(int[] arr, int spell, long success) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (((long) arr[mid] * spell) >= success) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
