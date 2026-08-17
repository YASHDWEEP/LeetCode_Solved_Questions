class Solution {
    public int longestSubsequence(int[] nums) {
        int total_xor = 0 ; 
        boolean allZero = true ;
        int n = nums.length;  
        for(int n1 : nums){
            total_xor = n1 ^ total_xor ; 

            if (n1 != 0 ){
                allZero = false  ;
            }
        }    
        if (allZero){
            return 0 ; 
        }
        if (total_xor != 0 ){
            return n ; 
        }
        return n-1 ; 
    }
}