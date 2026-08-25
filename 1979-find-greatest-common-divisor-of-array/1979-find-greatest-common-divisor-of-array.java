class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums){
            max = Math.max(num, max); 
            min = Math.min(num, min); 
        }       
        int GCD = 0;
        boolean GCD_found = false ; 
        for (int i = 2 ; i <= min; i++){
            if ((max % i == 0) && ( min % i == 0 )){
                GCD = i ;
                GCD_found = true ; 
            }
        }
        // if ((max % min == 0) && (!GCD_found)){
        //     return min; 
        // }
        return GCD_found ? GCD : 1 ; 
    }
}