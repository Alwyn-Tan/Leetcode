import java.util.*;

class Solution {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> result = new ArrayList<>();
    result.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= intervals[i - 1][1]) {
        result.remove(intervals[i - 1]);
        if (intervals[i - 1][1] <= intervals[i][1]) {
          result.add(new int[] { intervals[i - 1][0], intervals[i][1] });
        } else {
          result.add(intervals[i - 1]);
        }
      } else {
        result.add(intervals[i]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
