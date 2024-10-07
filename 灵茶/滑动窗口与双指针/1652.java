class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(i + j) % code.length];
                }
            } else if (k == 0) {
                ans[i] = 0;
            } else {
                for (int j = -1; j >= k; j--) {
                    ans[i] += code[(i + j + code.length) % code.length];
                }
            }
        }
        return ans;
    }
}