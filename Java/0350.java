import java.util.*;

class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int num : nums1) {
      list1.add(num);
    }
    for (int num : nums2) {
      if (list1.contains(num)) {
        list2.add(num);
        list1.remove(Integer.valueOf(num));
      }
    }
    int[] res = new int[list2.size()];
    int i = 0;
    for (int num : list2) {
      res[i] = num;
      i++;
    }
    return res;
  }
}
