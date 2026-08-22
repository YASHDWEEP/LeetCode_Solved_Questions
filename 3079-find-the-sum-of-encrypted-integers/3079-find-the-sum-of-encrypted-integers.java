class Solution {
    public static int max(int n){
        int max  = Integer.MIN_VALUE; 
        while(n > 0){
            int rem = n % 10 ; 
            max = Math.max(max ,rem); 
            n = n /10 ; 
        }
        return max ;
    } 
    public int encrypt(int n ){
        int max = max(n);
        String n1 = String.valueOf(n);
        StringBuilder n2 = new StringBuilder(); 

        for (int i = 0 ; i < n1.length() ; i++){
            n2.append("1");
        }
        int one_form = Integer.parseInt(n2.toString());
        return one_form * max ;
    }
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0 ; 
        for (int i = 0 ; i < nums.length  ; i++){
            sum += encrypt(nums[i]);
        }
        return sum ;
    }
}