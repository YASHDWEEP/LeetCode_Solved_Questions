// lets be funny 

class Solution {
    public int numSteps(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int steps = 0;
        int carry = 0;
        
        for (int i = n - 1; i > 0; i--) {
            int bit = (arr[i] - '0') + carry;
            if (bit == 0) {
                steps += 1;
                carry = 0;
            } else if (bit == 1) {
                steps += 2;
                carry = 1;
            } else { 
                steps += 1; 
                carry = 1; 
            }
        }
        
        if (carry == 1) steps++;
        
        return steps;
    }
}