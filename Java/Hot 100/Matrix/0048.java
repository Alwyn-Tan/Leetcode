class Solution {
    public void rotate(int[][] matrix) {
        int a = matrix[0].length;
        for (int i = 0; i < a / 2; i++) {
            for (int j = 0; j < a; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[a - i - 1][j];
                matrix[a - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}