class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n && j < i + r; j++) {
                sum += nums.get(j);
                int len = j - i + 1;
                if (sum > 0 && len >= l && len <= r) {
                    res = Math.min(res, sum);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}