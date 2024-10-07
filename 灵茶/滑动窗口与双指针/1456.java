package 灵茶.滑动窗口与双指针;

class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                vowels++;
            }
            if (i < k - 1) {
                continue;
            }
            res = Math.max(res, vowels);
            if (res == k) {
                return k;
            }
            if (s.charAt(i - k + 1) == 'a' || s.charAt(i - k + 1) == 'e' || s.charAt(i - k + 1) == 'i'
                    || s.charAt(i - k + 1) == 'o' || s.charAt(i - k + 1) == 'u') {
                vowels--;
            }
        }

        return res;
    }
}