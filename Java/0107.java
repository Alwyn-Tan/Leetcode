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

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> itemList = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode tempNode = queue.poll();
        itemList.add(tempNode.val);
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      }
      list.add(itemList);
    }
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for (int i = list.size() - 1; i >= 0; i--) {
      result.add(list.get(i));
    }
    return result;
  }
}
