import java.util.*;

class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s);
        return res;
    }

    public void backtrack(String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (judge(str)) {
                path.add(str);
                backtrack(s.substring(i + 1));
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean judge(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            if (i == j) {
                return true;
            }
        }
        return true;
    }
}