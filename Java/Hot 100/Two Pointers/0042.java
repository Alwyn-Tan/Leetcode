class Solution {

  public int trap(int[] height) {
    int[] pre = new int[height.length];
    int[] suf = new int[height.length];
    int ans = 0;
    pre[0] = height[0];
    suf[height.length - 1] = height[height.length - 1];
    for (int i = 1; i < pre.length; i++) {
      pre[i] = Math.max(height[i], pre[i - 1]);
    }
    for (int j = suf.length - 2; j > -1; j--) {
      suf[j] = Math.max(suf[j + 1], height[j]);
    }
    for (int i = 0; i < height.length; i++) {
      ans += Math.min(pre[i], suf[i]) - height[i];
    }
    return ans;
  }
}
