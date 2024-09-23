class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, visited, k)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean backtrack(char[][] board, String word, int i, int j, int[][] visited, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        boolean res = backtrack(board, word, i + 1, j, visited, k + 1) ||
                backtrack(board, word, i - 1, j, visited, k + 1) ||
                backtrack(board, word, i, j + 1, visited, k + 1) ||
                backtrack(board, word, i, j - 1, visited, k + 1);
        visited[i][j] = 0;
        return res;

    }
}