
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Find minimum price
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Calculate first-purchase rewards
        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            int freeCount = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeCount++;
                }
            }

            int reward = freeCount + 1;

            // Step 3: 0/1 Knapsack
            for (int j = budget; j >= price; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + reward
                );
            }
        }

        // Step 4: Use remaining budget on cheapest item
        int ans = 0;

        for (int j = 0; j <= budget; j++) {

            int remaining = budget - j;

            int total = dp[j] + remaining / minPrice;

            ans = Math.max(ans, total);
        }

        return ans;
    }
}
