// class Solution {

//     public static boolean isSpecial(int n) {
//         int count = 0;
//         for (int i = 0; i * i < n; i++) {
//             if (n % (i + 1) == 0) {
//                 count++;
//             }
//         }
//         return count > 2 || count < 2;
//     }

//     public int nonSpecialCount(int l, int r) {
//         int count = 0;
//         for (int i = l; i <= r; i++) {
//             if (isSpecial(i)) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {

    public int nonSpecialCount(int l, int r) {
        int total = r - l + 1;
        int special = 0;

        for (int i = 2; (long) i * i <= r; i++) {
            if (isPrime(i)) {
                int square = i * i;

                if (square >= l) {
                    special++;
                }
            }
        }

        return total - special;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
