import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] preRight = Arrays.copyOfRange(preorder, leftSize + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] inRight = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        TreeNode left = buildTree(preLeft, inLeft);
        TreeNode right = buildTree(preRight, inRight);
        return new TreeNode(preorder[0], left, right);
    }

    public int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}