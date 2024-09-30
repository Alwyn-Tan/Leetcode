class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = blocks.length();
        int white = 0;
        int black = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                white++;
            } else {
                black++;
            }
            if (i >= k - 1) {
                ans = Math.min(ans, white);
                if (blocks.charAt(i - (k - 1)) == 'W') {
                    white--;
                } else {
                    black--;
                }
            }
        }
        return ans;
    }
}
