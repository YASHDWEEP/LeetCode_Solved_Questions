class Solution {
    public int maxSubArray(int[] nums) {
        int Currsum = nums[0];
        int maxsum = nums[0] ; 
        for (int i = 1; i < nums.length; i++) {
            Currsum  = Math.max(nums[i]+ Currsum , nums[i]);
            maxsum = Math.max(maxsum , Currsum);
        }
        return maxsum;
    }
}