import java.util.*;

class Solution {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Character c;

    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else if (stack.isEmpty() || stack.peek() != c) {
        return false;
      } else {
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
