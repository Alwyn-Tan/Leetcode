import java.util.*;

class Solution {

  List<String> ans = new ArrayList<>();
  List<String> path = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    backTracking(s, 0);
    return ans;
  }

  public void backTracking(String s, int startIndex) {
    for (int i = startIndex; i < s.length(); i++) {
      String sub = s.substring(startIndex, i + 1);
      if (Integer.parseInt(sub) > 255) {
        continue;
      }
      path.add(sub);
      backTracking(s, i + 1);
      path.remove(path.size() - 1);
    }
  }
}
