class Solution {
    private int orignal_color;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        orignal_color = image[sr][sc];
        if (orignal_color == color) {
            return image;
        }
        dfs(image, sr, sc, color);
        return image;
    }

    private void dfs(int image[][], int i, int j, int color) {
        int m = image.length;
        int n = image[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (image[i][j] != orignal_color) {
            return;
        }
        image[i][j] = color;
        dfs(image, i + 1, j, color);
        dfs(image, i - 1, j, color);
        dfs(image, i, j + 1, color);
        dfs(image, i, j - 1, color);
    }

}