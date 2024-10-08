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

  public boolean judge(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return (
      (left.val == right.val) &&
      judge(left.left, right.right) &&
      judge(left.right, right.left)
    );
  }

  public boolean isSymmetric(TreeNode root) {
    return judge(root.left, root.right);
  }
}
