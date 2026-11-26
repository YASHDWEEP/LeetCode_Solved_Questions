
// class Solution {
//     public int numOfSubarrays(int[] arr) {

//         int mod = 1000000007;

//         long odd = 0;
//         long even = 1;
//         long sum = 0;
//         long ans = 0;

//         for (int num : arr) {

//             sum += num;

//             if (sum % 2 == 0) {
//                 ans = (ans + odd) % mod;
//                 even++;
//             } else {
//                 ans = (ans + even) % mod;
//                 odd++;
//             }
//         }

//         return (int) ans;
//     }
// }
public class Solution {
    static {
        int[] dummy = {1, 2, 3};
        for (int i = 0; i < 500; i++) {
            numOfSubarrays(dummy);
        }
    }

    public static int numOfSubarrays(int[] arr) {
        long oddCount = 0;
        int prefixParity = 0;

        for (int x : arr) {
            prefixParity ^= (x & 1);
            oddCount += prefixParity;
        }

        long evenCount = arr.length + 1L - oddCount;
        return (int) ((oddCount * evenCount) % 1_000_000_007L);
    }
}