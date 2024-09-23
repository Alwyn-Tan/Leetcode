/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order. */
class Solution {

  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int loop = 0;
    int start = 0;
    int num = 1;
    int i, j;
    while (loop < (int) n / 2) {
      for (j = start; j < n - loop - 1; j++) {
        res[start][j] = num;
        num++;
      }
      for (i = start; i < n - loop - 1; i++) {
        res[i][j] = num;
        num++;
      }
      for (; j > loop; j--) {
        res[i][j] = num;
        num++;
      }
      for (; i > loop; i--) {
        res[i][j] = num;
        num++;
      }
      loop++;
      start++;
    }
    if (n % 2 == 1) {
      res[start][start] = num;
    }
    return res;
  }
}
