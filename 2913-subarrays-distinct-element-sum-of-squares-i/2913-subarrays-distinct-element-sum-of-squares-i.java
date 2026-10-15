class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean[] vis = new boolean[101];
            for (int j = i; j < n; j++) {
                if (!vis[nums.get(j)]) {
                    vis[nums.get(j)] = true;
                    count++;
                }
                sum += count * count;
            }
        }
        return sum;
    }
}