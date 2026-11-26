class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10 ; 
        int turn = 0 ; 
        while (n >= remove ){
            n = n - remove ; 
            turn++; 
            remove-- ; 
        }       
        return turn % 2 != 0 ; 
    }
}