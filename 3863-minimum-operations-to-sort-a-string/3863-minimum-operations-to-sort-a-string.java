
// class Solution {
//     public int minOperations(String s) {
//         int n = s.length();
//         char min = 'z';
//         char max = 'a';
//         boolean sorted = true;

//         for (int i = 0; i < n; i++) {
//             min = (char) Math.min(min, s.charAt(i));
//             max = (char) Math.max(max, s.charAt(i));

//             if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
//                 sorted = false;
//             }
//         }

//         if (sorted) {
//             return 0;
//         }
//         if (n == 2) {
//             return -1;
//         }

//         if (s.charAt(0) == min || s.charAt(n - 1) == max) {
//             return 1;
//         }

//         for (int i = 1; i < n - 1; i++) {
//             if (s.charAt(i) == min || s.charAt(i) == max) {
//                 return 2;
//             }
//         }

//         return 3;
//     }
// }

class Solution {

    boolean isSorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) < s.charAt(i-1))return false;
        }
        return true;
    }

    public int minOperations(String s) {
        int n = s.length();
        if(isSorted(s))return 0;
        if(n==2)return -1;
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int first = 0, last = 25;
        while(freq[first]==0)first++;
        while(freq[last]==0)last--;
        if(s.charAt(0)-'a' == first){
            return 1;
        }
        else if(s.charAt(n-1)-'a' == last)return 1;
        else if(s.charAt(0)-'a' != last || s.charAt(n-1)-'a' != first || freq[first] > 1 || freq[last] > 1)return 2;
        else return 3;
    }
}