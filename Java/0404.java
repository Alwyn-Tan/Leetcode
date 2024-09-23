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

  public int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        if (temp.left.left == null && temp.left.right == null) {
          sum += temp.left.val;
        }
        stack.push(temp.left);
      }
    }

    return sum;
  }
}
