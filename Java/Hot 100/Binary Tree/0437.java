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

  public int pathSum(TreeNode root, int targetSum) {}

  public void recursive(TreeNode root, int targetSum, int count, int sum) {
    if (root == null) {
      return;
    }
    if (sum == targetSum) {
      count++;
    }
    recursive(root.left, targetSum, count, sum + root.val);
    recursive(root.right, targetSum, count, sum + root.val);
  }
}
