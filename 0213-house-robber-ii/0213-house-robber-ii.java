class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int case_1 = count_rob(nums, 0, n - 2);
        int case_2 = count_rob(nums, 1, n - 1);
        return Math.max(case_1, case_2);
    }

    public int count_rob(int nums[], int low, int high) {
        int p1 = 0, p2 = 0;
        for (int i = low; i <= high; i++) {
            int rob = nums[i] + p2;
            int skip = p1;
            int current = Math.max(rob, skip);
            p2 = p1;
            p1 = current;
        }
        return p1;
    }
}
