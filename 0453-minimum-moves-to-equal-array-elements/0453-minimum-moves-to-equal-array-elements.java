class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
        }
        int sum = 0;
        for (int n : nums) {
            sum += n - min;
        }
        return sum;
    }
}