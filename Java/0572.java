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

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (q == null && p == null) {
      return true;
    }
    if (q == null || p == null) {
      return false;
    }
    return (
      (p.val == q.val) &&
      isSameTree(p.left, q.left) &&
      isSameTree(p.right, q.right)
    );
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null || subRoot == null) {
      return false;
    }
    return (
      isSameTree(root, subRoot) ||
      isSubtree(root.left, subRoot) ||
      isSubtree(root.right, subRoot)
    );
  }
}
