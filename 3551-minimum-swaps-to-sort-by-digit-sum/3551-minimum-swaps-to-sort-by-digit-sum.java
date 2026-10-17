import java.util.*;

class Solution {
    private static int digitsum(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][3];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = digitsum(nums[i]);
            pairs[i][1] = nums[i];
            pairs[i][2] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        boolean[] vis = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || pairs[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!vis[j]) {
                vis[j] = true;
                j = pairs[j][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}