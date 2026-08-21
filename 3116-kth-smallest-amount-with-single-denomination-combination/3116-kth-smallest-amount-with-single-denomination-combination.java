class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        // Safe upper bound
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = count(mid, coins, k);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins, int k) {

        int n = coins.length;
        long result = 0;

        // All non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long gcd = gcd(lcm, coins[i]);

                    // lcm = lcm / gcd * coin
                    long temp = lcm / gcd;

                    if (temp > x / coins[i]) {
                        overflow = true;
                        break;
                    }

                    lcm = temp * coins[i];

                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            // If LCM > x, x / LCM = 0
            if (overflow) {
                continue;
            }

            long current = x / lcm;

            if (bits % 2 == 1) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}