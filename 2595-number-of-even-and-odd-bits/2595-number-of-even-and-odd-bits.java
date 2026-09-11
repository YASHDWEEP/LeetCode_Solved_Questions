class Solution {
    public int[] evenOddBit(int n) {
        String binary = Integer.toBinaryString(n);
       
        int even = 0;
        int odd = 0;
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i)== '1'){
                int bitposition = binary.length() -1 - i; 
                if (bitposition % 2 == 0){
                    even++;
                }else {
                    odd++;
                }
            }
         }
        return new int[] {  even ,odd};
    }
}