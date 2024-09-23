import java.util.*;

class Solution {

  public String removeDuplicates(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (stack.isEmpty() || stack.peek() != c) {
        stack.push(c);
      } else {
        stack.pop();
      }
    }
    while (!stack.isEmpty()) {
      res += stack.pop();
    }
    return new StringBuffer(res).reverse().toString();
  }
}
