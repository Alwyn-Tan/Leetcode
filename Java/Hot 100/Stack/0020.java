import java.util.*;

class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        for (char c : arr) {
            if (!map.containsKey(c)) {
                deque.push(c);
            } else if (deque.isEmpty() || deque.pop() != map.get(c)) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}