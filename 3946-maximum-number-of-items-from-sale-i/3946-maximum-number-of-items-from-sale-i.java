class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int minprice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minprice = Math.min(minprice, item[1]);
        }
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            int freecount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freecount++;
                }
            }
            int reward = freecount + 1;

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + reward);
            }

        }
        int ans = 0;
        for (int x = 0; x <= budget; x++) {
            int remain = budget - x;
            int total = dp[x] + remain / minprice;
            ans = Math.max(ans, total);
        }
        return ans;
    }
}