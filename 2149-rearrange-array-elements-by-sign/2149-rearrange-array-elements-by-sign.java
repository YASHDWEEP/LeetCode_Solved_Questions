class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pI = 0;
        int nI = 1;
        int[] new_arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                new_arr[pI] = nums[i];
                pI += 2;
            } else {
                new_arr[nI] = nums[i];
                nI += 2;
            }
        }
        return new_arr;
    }
}