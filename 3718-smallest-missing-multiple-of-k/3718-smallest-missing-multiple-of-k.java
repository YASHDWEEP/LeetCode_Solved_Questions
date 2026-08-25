class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(); 
        for(int num : nums){
            set.add(num);
        }
        int number = 1 ; 
        for (int i = 1 ; i <= nums.length +1; i++){
            number = k * i ; 
            if (!set.contains(number)){
                break ; 
            }
        }
        return number ;
    }
}