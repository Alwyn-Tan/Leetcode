
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int right = 0;
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right - left);
            right++;
        }
        return result;
    }
}