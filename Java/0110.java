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

  public int Height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(Height(root.left), Height(root.right));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      if (Math.abs(Height(temp.left) - Height(temp.right)) > 1) {
        return false;
      }
      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
    return true;
  }
}

class MainClass {

  public static TreeNode createTree(int[] arr) {
    TreeNode[] nodes = new TreeNode[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        nodes[i] = null;
      } else {
        nodes[i] = new TreeNode(arr[i]);
      }
      if (i > 0) {
        int pi = (i - 1) / 2;
        if (i == 2 * pi + 1) {
          nodes[pi].left = nodes[i];
        } else {
          nodes[pi].right = nodes[i];
        }
      }
    }
    return nodes[0];
  }
}
