import java.util.*;

class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> res = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }
    for (int num : nums2) {
      if (set.contains(num)) {
        res.add(num);
      }
    }
    int[] list = new int[res.size()];
    int index = 0;
    for (int num : res) {
      list[index] = num;
      index++;
    }
    return list;
  }
}
