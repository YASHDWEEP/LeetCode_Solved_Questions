class Solution {
    boolean dp[][][];
    private int ans;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ans = Integer.MAX_VALUE;
        dp = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0, m, n);
        return ans;
    }

    private void dfs(int grid[][], int i, int j, int xor, int m, int n) {
        xor = xor ^ grid[i][j];
        if (ans == 0) {
            return;
        }
        if (dp[i][j][xor]) {
            return;
        }
        dp[i][j][xor] = true;
        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xor);
            return;
        }
        if (i + 1 < m) {
            dfs(grid, i + 1, j, xor, m, n);
        }
        if (j + 1 < n) {
            dfs(grid, i, j + 1, xor, m, n);
        }
    }
}
// class Solution {
//     public int minCost(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int MAX = 1034;
//         int dummy[][] = grid;

//         boolean dp[][][] = new boolean[m][n][MAX];
//         dp[0][0][dummy[0][0]] = true;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 && j == 0) {
//                     continue;
//                 }
//                 for (int x = 0; x < MAX; x++) {
//                     if (i > 0 && dp[i - 1][j][x]) {
//                         int new_xor = x ^ dummy[i][j];
//                         dp[i][j][new_xor] = true;
//                     }
//                     if (j > 0 && dp[i][j - 1][x]) {
//                         int new_xor = x ^ dummy[i][j];
//                         dp[i][j][new_xor] = true;
//                     }
//                 }
//             }
//         }
//         for (int x = 0; x < MAX; x++) {
//             if (dp[m - 1][n - 1][x]) {
//                 return x;
//             }
//         }
//         return 0 ;
//     }
// }
