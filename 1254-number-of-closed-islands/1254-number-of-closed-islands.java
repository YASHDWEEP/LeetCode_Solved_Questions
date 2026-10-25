class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int grid[][], int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (c < 0 || c >= n || r < 0 || r >= m) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        grid[r][c] = 1;
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);
        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);

        return left && right && up && down;
    }
}