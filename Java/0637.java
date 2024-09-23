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

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Double> res = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      double size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode tempNode = queue.poll();
        sum += tempNode.val;
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      }
      double num = sum / size;
      res.add(num);
    }
    return res;
  }
}
