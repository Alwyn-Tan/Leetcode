import java.util.*;

class Solution {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int start_s = s.length - 1;
    for (int i = g.length - 1; i >= 0; i--) {
      if (start_s >= 0 && s[start_s] >= g[i]) {
        count++;
        start_s--;
      }
    }
    return count;
  }
}
