
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;
    long[] fact;

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }

    private long comb(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }

        long denominator =
            fact[r] * fact[n - r] % MOD;

        return fact[n] * power(denominator, MOD - 2) % MOD;
    }

    private long ways(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long choose = comb(n - 1, left.size());

        long leftWays = ways(left);
        long rightWays = ways(right);

        return choose * leftWays % MOD
                    * rightWays % MOD;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;

        fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return (int) ((ways(list) - 1 + MOD) % MOD);
    }
}
