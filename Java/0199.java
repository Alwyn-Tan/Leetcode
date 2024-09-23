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

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode tempNode = queue.poll();
        if (i == size - 1) {
          result.add(tempNode.val);
        }
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      }
    }
    return result;
  }
}
