/* Given an m x n matrix, return all elements of the matrix in spiral order. */
import java.util.*;

class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();
    int left = 0;
    int right = matrix[0].length - 1;
    int top = 0;
    int bottom = matrix.length - 1;
    int N = (right + 1) * (bottom + 1);
    while (N > 0) {
      for (int i = left; i < right && N > 0; i++) {
        res.add(matrix[top][i]);
        N--;
      }
      for (int i = top; i < bottom && N > 0; i++) {
        res.add(matrix[i][right]);
        N--;
      }
      for (int i = right; i > left && N > 0; i--) {
        res.add(matrix[bottom][i]);
        N--;
      }
      for (int i = bottom; i > top && N > 0; i--) {
        res.add(matrix[i][left]);
        N--;
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return res;
  }
}
