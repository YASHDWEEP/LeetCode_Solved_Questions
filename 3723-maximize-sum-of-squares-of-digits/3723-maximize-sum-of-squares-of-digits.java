class Solution {
    public static int length(int n ){
        int c = 0 ; 
        while(n > 0 ){
            n = n/10 ; 
            c++; 
        }
        return c ; 
    }
    public String maxSumOfSquares(int num, int sum) {
        if (num < length(sum)){
            return ""; 
        }
        StringBuilder res = new StringBuilder(); 
        // boolean j = false ; 
        while (num > 0  ){
            res.append(Math.min(9,Math.max(sum,0 ))); 
            sum-=9; 
            num--; 
            if (num == 0 &&sum > 0){
                return "";
            }
        }  

        return res.toString(); 
    }
}