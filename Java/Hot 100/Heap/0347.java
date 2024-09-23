import java.util.*;

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
          return map.get(a) - map.get(b);
        }
      }
    );
    for (int key : map.keySet()) {
      pq.add(key);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }
    return res;
  }
}
