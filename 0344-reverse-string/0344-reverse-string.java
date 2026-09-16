class Solution {
    public void reverseString(char[] s) {
        // char [] s1 = new char[s.length]; 
        // int index = 0 ; 
        // for (int i = s.length -1 ; i>=0 ; i-- ){
        //     s1[index] = s[i];
        //     index++; 
        // }
        int left = 0;
        int right = s.length -1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}