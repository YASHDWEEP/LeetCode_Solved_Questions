class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int r, int c, int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        grid[r][c] = 1;
        boolean left = dfs(r, c - 1, grid);
        boolean right = dfs(r, c + 1, grid);
        boolean up = dfs(r - 1, c, grid);
        boolean down = dfs(r + 1, c, grid);
        return left && right && up && down;
    }
}