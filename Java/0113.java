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

  public void path(
    TreeNode root,
    int targetSum,
    List<Integer> path,
    List<List<Integer>> res
  ) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
      if (root.val == targetSum) {
        res.add(new ArrayList<>(path));
      }
      return;
    }
    if (root.left != null) {
      path(root.left, targetSum - root.val, path, res);
      path.remove(path.size() - 1);
    }
    if (root.right != null) {
      path(root.right, targetSum - root.val, path, res);
      path.remove(path.size() - 1);
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    List<Integer> path = new ArrayList<>();

    path(root, targetSum, path, res);
    return res;
  }
}
