import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String subString = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (Character c : subString.toCharArray()) {
                set.add(c);
            }
            if (set.size() <= maxLetters) {
                map.put(subString, map.getOrDefault(subString, 0) + 1);
                ans = Math.max(ans, map.get(subString));
            }
        }
        return ans;
    }
}