class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        for(int j=1;j<=set.size()+1;j++){
            if(!set.contains(k*j)){
                return k*j;
            }
        }
        return 0;
    }
}