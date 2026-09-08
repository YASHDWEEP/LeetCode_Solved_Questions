class Solution {
    public int lengthofn(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count += 1;
        }
        return count;
    }

    public int countCommas(int n) {
        int count_commas = 1 ; 
        if (lengthofn(n) < 4){
            return 0 ; 
        }
        // if (n == 100000){
        //     count_commas+=2 ; 
        // }
        
            int total_numbers = n - 1000; 
            count_commas += total_numbers;
        
        return count_commas; 
    }
}