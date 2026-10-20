
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = 0;

            for (int start = 0; start < n; start += k) {
                int min = nums[start];
                int max = nums[start];
                int descents = 0;

                for (int i = start; i < start + k; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);

                    int next = (i + 1 == start + k)
                            ? start : i + 1;

                    if (nums[i] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1 ||
                    (start > 0 && prevMax > min)) {
                    valid = false;
                    break;
                }

                prevMax = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
