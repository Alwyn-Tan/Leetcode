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

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return res;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();
        levelList.add(temp.val);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      res.add(Collections.max(levelList));
    }
    return res;
  }
}
