
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];

        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        // Precompute prefix hashes and powers
        for (int i = 0; i < n; i++) {

            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;

            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
        }

        // Binary Search
        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, n)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    boolean check(int len, int n) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Generate all subarrays of length len
        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long hash1 = (h1[j] - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;

            long hash2 = (h2[j] - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            // Combine both hashes
            long key = (hash1 << 32) | hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check for a unique subarray
        for (int freq : map.values()) {

            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
