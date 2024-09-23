class Solution {

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  void dfs(char[][] grid, int i, int j) {
    if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length) {
      if (grid[i][j] != '1') {
        return;
      }
      grid[i][j] = '2';
      dfs(grid, i, j + 1);
      dfs(grid, i, j - 1);
      dfs(grid, i - 1, j);
      dfs(grid, i + 1, j);
    } else {
      return;
    }
  }
}
