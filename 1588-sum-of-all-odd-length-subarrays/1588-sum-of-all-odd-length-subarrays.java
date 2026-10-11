// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
//         // 1 st brute force using three loops
//         int sum = 0;
//         int n = arr.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j += 2) {
//                 for (int k = i; k <= j; k++) {
//                     sum += arr[k];
//                 }
//             }
//         }
//         return sum;
//     }
// }
// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
//         int n = arr.length;
//         int total = 0;

//         for (int i = 0; i < n; i++) {
//             int count = ((i + 1) * (n - i) + 1) / 2;
//             total += arr[i] * count;
//         }

//         return total;
//     }
// }
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int k = 1; k <= n; k += 2) {
            int windowSum = 0;

            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }

            total += windowSum;

            for (int right = k; right < n; right++) {
                windowSum -= arr[right - k];
                windowSum += arr[right];

                total += windowSum;
            }
        }

        return total;
    }
}