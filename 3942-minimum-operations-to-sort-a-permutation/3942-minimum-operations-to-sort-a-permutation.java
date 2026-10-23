// class Solution {
//     public int minOperations(int[] nums) {
//         int n = nums.length;
//         int zero = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 zero = i;
//                 break;
//             }
//         }
//         int ans = Integer.MAX_VALUE;

//         if (check(nums, zero, 1)) {
//             ans = Math.min(ans, zero);
//             ans = Math.min(ans, n - zero + 2);
//         }
//         if (check(nums, zero, -1)) {
//             ans = Math.min(ans, zero + 2);
//             ans = Math.min(ans, n - zero);
//         }
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }

//     public boolean check(int nums[], int zero, int step) {
//         int n = nums.length;
//         for (int i = 1; i < n; i++) {
//             int prev = (zero + (i - 1) * step + n) % n;
//             int curr = (zero + i * step + n) % n;
//             if (nums[prev] > nums[curr]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public int minOperations(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int start = 0;
        while (nums[start] != 0) {
            start++;
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 1; i < n; i++) {
            int value = nums[(start + i) % n];

            if (value != i) {
                asc = false;
            }
            if (value != n - i) {
                desc = false;
            }

            if (!asc && !desc) {
                return -1;
            }
        }

        if (asc) {
            return Math.min(start, n - start + 2);
        }

        return Math.min(n - start, start + 2);
    }
}