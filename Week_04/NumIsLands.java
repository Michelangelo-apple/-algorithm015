public class NumIsLands {
//存储的是字符，需要用单引号，并不是数字
    public int numIslands(char[][] grid) {
        if  (grid == null) {
            return 0;
        }
        int n = grid.length;
        if (n ==  0) {
            return 0;
        }
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,n,m,i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid,n,m,i - 1,j);
        dfs(grid,n,m,i + 1,j);
        dfs(grid,n,m,i,j - 1);
        dfs(grid,n,m,i,j + 1);
    }


}
