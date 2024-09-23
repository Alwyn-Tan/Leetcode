class Solution {

  public void reverse(int l, int r, char[] s) {
    while (l < r) {
      char temp = s[l];
      s[l] = s[r];
      s[r] = temp;
      l++;
      r--;
    }
  }

  public String reverseStr(String s, int k) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i += 2 * k) {
      if (i + k <= arr.length) {
        reverse(i, i + k - 1, arr);
      } else {
        reverse(i, arr.length - 1, arr);
      }
    }
    String res = new String(arr);
    return res;
  }
}
