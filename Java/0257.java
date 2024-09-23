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

  List<String> res = new ArrayList<>();

  public void findPaths(TreeNode root, String str) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      res.add(str + root.val);
      return;
    }
    String temp = str + root.val + "->";
    findPaths(root.left, temp);
    findPaths(root.right, temp);
  }

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return res;
    }
    findPaths(root, "");
    return res;
  }
}
