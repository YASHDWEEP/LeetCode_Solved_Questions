
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        if (k >= totalDiff) {
            return 0;
        }

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long required = 0;

            for (int d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int x = low;
        long used = 0;
        long ans = 0;
        long countAtX = 0;

        for (int d : diff) {
            if (d > x) {
                used += d - x;
                d = x;
            }

            ans += (long) d * d;

            if (d == x && x > 0) {
                countAtX++;
            }
        }

      
        long remaining = k - used;
        ans -= remaining * (2L * x - 1);

        return ans;
    }
}
