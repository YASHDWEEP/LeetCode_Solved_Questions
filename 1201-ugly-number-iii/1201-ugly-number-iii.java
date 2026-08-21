class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long low = 1;

        long high = (long) Math.min(a, Math.min(b, c)) * n;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countUgly(mid, a, b, c);

            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private long countUgly(long x, long a, long b, long c) {

        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(ab, c);

        return x / a
             + x / b
             + x / c
             - x / ab
             - x / ac
             - x / bc
             + x / abc;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }
}