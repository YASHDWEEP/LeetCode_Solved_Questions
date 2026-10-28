class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignal_color = image[sr][sc];
        if (orignal_color == color) {
            return image;
        }
        dfs(image, sr, sc, orignal_color, color);
        return image;
    }

    private void dfs(int image[][], int sr, int sc, int or, int co) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != or) {
            return;
        }
        image[sr][sc] = co;
        dfs(image, sr - 1, sc, or, co);
        dfs(image, sr + 1, sc, or, co);
        dfs(image, sr, sc - 1, or, co);
        dfs(image, sr, sc + 1, or, co);
    }
}