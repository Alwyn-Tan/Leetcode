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

  public int maxDepth = -1;
  public int result;

  public void traversal(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (depth > maxDepth) {
        maxDepth = depth;
        result = root.val;
        return;
      }
    }
    if (root.left != null) {
      traversal(root.left, depth + 1);
    }
    if (root.right != null) {
      traversal(root.right, depth + 1);
    }
    return;
  }

  public int findBottomLeftValue(TreeNode root) {
    traversal(root, 0);
    return result;
  }
}
