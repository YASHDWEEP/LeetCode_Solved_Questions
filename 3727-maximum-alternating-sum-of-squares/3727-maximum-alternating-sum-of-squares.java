class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] * nums[i]);
        }
        Arrays.sort(nums);
        int mid = (0 + nums.length) / 2;
        long sum = 0;
        for (int i = mid; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < mid; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}