class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
        }
        for (int n : nums) {
            sum += n- min ;
        }
        return sum;
    }
}