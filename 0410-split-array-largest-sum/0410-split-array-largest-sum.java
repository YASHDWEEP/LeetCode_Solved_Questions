class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Find maximum element and total sum
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Binary Search
        while (left < right) {

            int mid = left + (right - left) / 2;

            // Check how many subarrays are required
            int subarrays = 1;
            int currentSum = 0;

            for (int num : nums) {

                if (currentSum + num > mid) {
                    subarrays++;
                    currentSum = num;
                } else {
                    currentSum += num;
                }
            }

            // Too many subarrays -> mid is too small
            if (subarrays > k) {
                left = mid + 1;
            }
            // We can use k or fewer subarrays -> try smaller
            else {
                right = mid;
            }
        }

        return left;
    }
}