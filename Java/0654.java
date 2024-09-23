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

  public int findMax(int[] nums, int left, int right) {
    int maxIndex = left;
    while (left < right) {
      if (nums[maxIndex] < nums[left]) {
        maxIndex = left;
      }
      left++;
    }
    return maxIndex;
  }

  public TreeNode buildTree(int[] nums, int start, int end) {
    if (start >= end) {
      return null;
    }
    int index = findMax(nums, start, end);
    TreeNode root = new TreeNode(nums[index]);
    root.left = buildTree(nums, start, index);
    root.right = buildTree(nums, index + 1, end);
    return root;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return buildTree(nums, 0, nums.length);
  }
}
