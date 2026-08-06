class Solution {
    private static int product(int n ){
        int product =1 ; 
        while (n > 0 ){
            int digit = n % 10 ; 
            product *= digit ; 
            n = n/10 ; 
        }
        return product ; 
    }
    public int smallestNumber(int n, int t) {
        for (int i = n ; i <= 100 ; i++){
            if (product(i) % t == 0){
                return i ; 
            }
        }       
        return 0 ; 
    }
}