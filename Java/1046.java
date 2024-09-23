import java.util.*;

class Solution {

  public int lastStoneWeight(int[] stones) {
    List<Integer> list = new ArrayList<>();
    for (int stone : stones) {
      list.add(stone);
    }
    while (list.size() > 1) {
      Collections.sort(list);
      Integer stone1 = list.get(list.size() - 1);
      Integer stone2 = list.get(list.size() - 2);
      Integer stone_left = stone1 - stone2;
      if (stone_left > 0) {
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.add(stone_left);
      } else {
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
      }
    }
    return list.size() == 0 ? 0 : list.get(0);
  }
}
