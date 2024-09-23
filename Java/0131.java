import java.util.*;

class Solution {

  List<List<String>> res = new ArrayList<>();
  List<String> path = new ArrayList<>();

  public List<List<String>> partition(String s) {
    backtrack(s);
    return res;
  }

  public void backtrack(String s) {
    if(s.length()==0){
      res.add(new ArrayList<>(path));
    }
      for(int i=0;i<s.length();i++){
        String pre = s.substring(0,i+1);
        if(judge(pre)){
          path.add(pre);
        } else{
          continue;
        }
        String last = s.substring(i+1);
        backtrack(last);
        path.remove(path.size()-1);
      }
  }

  public boolean judge(String s) {
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
