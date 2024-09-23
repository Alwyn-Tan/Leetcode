import java.util.*;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    int P = p.length();
    int[] mapS = new int[26];
    int[] mapP = new int[26];
    for (int i = 0; i < P; i++) {
      mapP[p.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      mapS[s.charAt(i) - 'a']++;
      if (i >= P - 1) {
        if (Arrays.equals(mapS, mapP)) {
          list.add(i - P + 1);
        }
        mapS[s.charAt(i - P + 1) - 'a']--;
      }
    }
    return list;
  }
}
