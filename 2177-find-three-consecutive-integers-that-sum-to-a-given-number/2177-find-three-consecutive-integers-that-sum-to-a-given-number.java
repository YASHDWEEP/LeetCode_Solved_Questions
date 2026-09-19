class Solution {
    public long[] sumOfThree(long num) {
        long x = num / 3;
        if (((x - 1) + x + (x + 1)) == num) {
            return new long[] { x - 1, x, x + 1 };
        }
        return new long[] {};

    }
}