import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if (top + 1 <= bottom) {
                top++;
            } else {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (right - 1 >= left) {
                right--;
            } else {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            if (bottom - 1 >= top) {
                bottom--;
            } else {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if (left + 1 <= right) {
                left++;
            } else {
                break;
            }
        }
        return ans;
    }
}