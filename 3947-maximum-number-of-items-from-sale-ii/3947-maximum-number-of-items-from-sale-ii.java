
import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int maxFactor = n;

        // Step 1: Count frequency of each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 2: Count all divisible item types
        int[] count = new int[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                count[i] += freq[j];
            }
        }

        // Step 3: Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int minPrice = items[0][1];

        long remaining = budget;
        long ans = 0;

        // Step 4: Greedily use beneficial bonus purchases
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (price > 2L * minPrice) {
                break;
            }

            // Exclude the item itself
            int freeCount = count[factor] - 1;

            long take = Math.min(
                (long) freeCount,
                remaining / price
            );

            ans += 2 * take;
            remaining -= take * price;
        }

        // Step 5: Buy additional cheapest items
        ans += remaining / minPrice;

        return (int) ans;
    }
}
