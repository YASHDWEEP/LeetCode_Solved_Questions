class Solution {
    public int CountofN(long n) {
        int count = 0;
       if (n ==0 ){
        return 1 ; 
       }
        while (n != 0) {
            count += 1;
            n = n / 10;
            
        }
        return count;
    }

    // public long countCommas(long n) {
    //     long count_commas = 0;
    //     int length = CountofN(n);
    //     if (length < 4) {
    //         return 0;
    //     }
    //     if (length < 6) {
    //         count_commas = n - ((long) Math.pow(10, 3) - 1);
    //     } else if (length < 8 && length >= 5) {
    //         count_commas = 2 * (n - ((long) Math.pow(10, 5) - 1)) + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));
    //     } else if (length < 10 && length >= 7) {
    //         count_commas = 3 * (n - (long) Math.pow(10, 7) - 1)
    //                 + (2 * ((long) Math.pow(10, 7) - ((long) Math.pow(10, 5))))
    //                 + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));
    //     } else if (length < 12 && length >= 9) {
    //         count_commas = 4 * (n - (long) Math.pow(10, 9) - 1) + 3 * ((long) Math.pow(10, 9) - (long) Math.pow(10, 7))
    //                 + (2 * ((long) Math.pow(10, 7) - ((long) Math.pow(10, 5))))
    //                 + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));
    //     } else if (length < 14 && length >= 11) {
    //         count_commas = 5 * (n - (long) Math.pow(10, 11) - 1)
    //                 + 4 * ((long) Math.pow(10, 11) - (long) Math.pow(10, 9))
    //                 + 3 * ((long) Math.pow(10, 9) - (long) Math.pow(10, 7))
    //                 + (2 * ((long) Math.pow(10, 7) - ((long) Math.pow(10, 5))))
    //                 + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));
    //     } else if (length < 16 && length >= 13) {
    //         count_commas = 6 * (n - (long) Math.pow(10, 13) - 1)
    //                 + 5 * ((long) Math.pow(10, 13) - (long) Math.pow(10, 11))
    //                 + 4 * ((long)Math.pow(10, 11) - (long) Math.pow(10, 9))
    //                 + 3 * ((long) Math.pow(10, 9) - (long) Math.pow(10, 7))
    //                 + (2 * ((long) Math.pow(10, 7) - ((long) Math.pow(10, 5))))
    //                 + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));
    //     } else {
    //         count_commas = 7 + 6 * ((long) Math.pow(10, 15) - (long) Math.pow(10, 13))
    //                 + 5 * ((long) Math.pow(10, 13) - (long) Math.pow(10, 11))
    //                 + 4 * ((long)Math.pow(10, 11) - (long) Math.pow(10, 9))
    //                 + 3 * ((long) Math.pow(10, 9) - (long) Math.pow(10, 7))
    //                 + (2 * ((long) Math.pow(10, 7) - ((long) Math.pow(10, 5))))
    //                 + ((long) Math.pow(10, 5) - (long) Math.pow(10, 3));

    //     }

    //     // for (int i = 3; i < length; i += 2) {
    //     //     count_commas += 9 * Math.pow(11, i + 2) - Math.pow(10, i);
    //     // }

    //     // if (n < 999) {
    //     //     return 0;
    //     // } else if (n >= 1000 && n < 100000) {
    //     //     count_commas += n - 999;
    //     // } else if (n >= 100000 && n < 10000000) {
    //     //     count_commas = ( 99999 - 999) * 1 + (n - 100000) * 2;
    //     // } else if (n >= 10000000 && n < 1000000000) {
    //     //     count_commas = (n - 1000) * 1 + (n - 100000) * 2 + (n - 10000000) * 3;
    //     // } else if (n >= 1000000000 && n < 100000000000) {
    //     //     count_commas = (n - 1000) * 1 + (n - 100000) * 2 + (n - 10000000) * 3 + (n - 1000000000) * 4;
    //     // } else if (n >= 100000000000 && n < 10000000000000) {
    //     //     count_commas = (n - 1000) * 1 + (n - 100000) * 2 + (n - 10000000) * 3 + (n - 1000000000) * 4
    //     //             + (n - 100000000000) * 5;
    //     // } else if (n >= 10000000000000 && n < 1000000000000000) {
    //     //     count_commas = (n - 1000) * 1 + (n - 100000) * 2 + (n - 10000000) * 3 + (n - 1000000000) * 4
    //     //             + (n - 100000000000) * 5 + (n - 10000000000000) * 6;
    //     // } else {
    //     //     count_commas = (n - 1000) * 1 + (n - 100000) * 2 + (n - 10000000) * 3 + (n - 1000000000) * 4
    //     //             + (n - 100000000000) * 5 + (n - 10000000000000) * 6 + 7;

    //     // }
    //     return count_commas;
    // }
    public long countCommas(long n) {
        long count_commas = 0;

        for (long power = 1000; power <= n;) {
            count_commas += n - power + 1;

            if (power > n / 1000) {
                break;
            }

            power *= 1000;
        }

        return count_commas;
    }
}