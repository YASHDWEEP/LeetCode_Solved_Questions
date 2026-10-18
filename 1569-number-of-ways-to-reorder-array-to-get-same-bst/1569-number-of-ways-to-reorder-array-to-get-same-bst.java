class Solution {
    static Long MOD = 1_000_000_007L;
    long[] fact;

    private long pow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD ;
            }
            a = a* a % MOD ; 
            b >>= 1 ; 
        }
        return result ; 
    }

    public long comb(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        long denominator = fact[r] * fact[n - r] % MOD;
        return fact[n] * pow(denominator, MOD - 2) % MOD;
    }

    public  long ways(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        long choose = comb(n - 1, left.size());
        long leftways = ways(left);
        long rightways = ways(right);
        return choose * leftways % MOD * rightways % MOD;
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