class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
        for (int n : nums) {
            totalsum += n;
        }
        int target = totalsum - x;
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int current_sum = 0;
        int longest_subarray_length = 0;
        boolean isfound = false;
        for (int right = 0; right < nums.length; right++) {
            current_sum += nums[right];
            while (current_sum > target) {
                current_sum -= nums[left++];
            }
            if (current_sum == target) {
                longest_subarray_length = Math.max(longest_subarray_length, right - left + 1);
                isfound = true;
            }
        }
        return isfound ? nums.length - longest_subarray_length : -1;
    }
}
