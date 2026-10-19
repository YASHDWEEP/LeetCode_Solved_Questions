class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessthantarget = 0, targetfound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                lessthantarget++;
            }
            if (nums[i] == target) {
                targetfound++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < targetfound; i++) {
            list.add(lessthantarget + i);
        }
        return list;
    }
}