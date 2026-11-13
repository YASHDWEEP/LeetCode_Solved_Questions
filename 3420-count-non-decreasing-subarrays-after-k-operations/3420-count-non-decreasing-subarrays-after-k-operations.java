
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int count = 1;

            // Merge smaller segments
            while (!dq.isEmpty() && dq.peekFirst()[0] < nums[i]) {

                int[] curr = dq.pollFirst();

                cost += (long) (nums[i] - curr[0]) * curr[1];

                count += curr[1];
            }

            // Add current element
            dq.offerFirst(new int[]{nums[i], count});

            // Shrink window if cost exceeds k
            while (cost > k) {

                int[] last = dq.peekLast();

                cost -= last[0] - nums[j];

                last[1]--;

                if (last[1] == 0) {
                    dq.pollLast();
                }

                j--;
            }

            // Count valid subarrays
            ans += (j - i + 1);
        }

        return ans;
    }
}
