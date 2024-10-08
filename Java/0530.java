import java.util.*;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  int result = Integer.MAX_VALUE;
  TreeNode pre;

  public void traversal(TreeNode root) {
    if (root == null) {
      return;
    }
    traversal(root.left);
    if (pre != null) {
      result = Math.min(result, root.val - pre.val);
    }
    pre = root;
    traversal(root.right);
  }

  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return 0;
    }
    traversal(root);
    return result;
  }
}
