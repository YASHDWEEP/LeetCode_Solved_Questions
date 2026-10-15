class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> HS = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                HS.add(nums.get(j));
                sum += (HS.size() * HS.size());
            }
        }
        return sum;
    }
}