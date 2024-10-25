import java.util.*;

class Solution {

  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int ans = 0;
    Arrays.sort(arr2);
    for (int i : arr1) {
      ans += lowerBound(arr2, i, d);
    }
    return ans;
  }

  public int lowerBound(int[] arr, int target, int d) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (Math.abs(arr[mid] - target) > d) {
        if (arr[mid] - target > d) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        return 0;
      }
    }
    return 1;
  }
}
