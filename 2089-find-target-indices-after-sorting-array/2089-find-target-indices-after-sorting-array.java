class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums); 
        boolean found = false ; 
        List<Integer> list =  new ArrayList<>(); 
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] == target){
                list.add(i); 
                found = true ; 
            }
            if (found && nums[i] != target){
                break ; 
            }
        }   
        return list ; 
    }
}