class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 1;
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> S = new HashSet<>();
        for (int n : nums) {
            S.add(n);
        }
        for (int n : S) {
            int count = 1;
            if (!S.contains(n - 1)) {
                int curr = n ; 
                while (S.contains(curr + 1)) {
                    count++;
                    curr++; 
                }
                length = Math.max(count, length);
            }
        }

        return length;
    }
}