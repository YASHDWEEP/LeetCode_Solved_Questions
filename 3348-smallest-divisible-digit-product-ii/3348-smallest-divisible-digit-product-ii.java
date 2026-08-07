// class Solution {
    
//     private static Long product (long num){
//         long product = 1 ; 
//         while ( num > 0 ){
//             long remainder = num % 10 ; 
//             product *= remainder; 
//             num /= 10 ; 
//         }
//         return product ; 
//     } 
//     private static boolean zerofree(long num ){
//       while ( num > 0 ){
//             long remainder = num % 10 ; 
//             if (remainder == 0 ){
//                 return false ; 
//             }
//             num /= 10 ; 
//         }   
//         return true ; 
//     }
//     public String smallestNumber(String num, long t) {
//         long num1 = Long.parseLong(num);
//         for (long i = num1 ; i  < num1 + 100000 ;i++ ){
//             if ((product(i) % t == 0 ) && (zerofree(i))){
//                 return String.valueOf(i); 
//             }
//         }  
//         return String.valueOf(-1) ; 
//     }
// }
import java.util.*;

class Solution {
    // Prime-factor counts (2,3,5,7) contributed by each digit 1-9
    private static final Map<Integer, Map<Integer, Integer>> DIGIT_FACTORS = Map.of(
        1, Map.of(),
        2, Map.of(2, 1),
        3, Map.of(3, 1),
        4, Map.of(2, 2),
        5, Map.of(5, 1),
        6, Map.of(2, 1, 3, 1),
        7, Map.of(7, 1),
        8, Map.of(2, 3),
        9, Map.of(3, 2)
    );

    public String smallestNumber(String num, long t) {
        Map<Integer, Integer> need = factorizeT(t);
        if (need == null) return "-1";

        Map<Integer, Integer> minForm = digitsForFactors(need);
        if (total(minForm) > num.length()) {
            return buildFromDigitCounts(minForm);
        }

        Map<Integer, Integer> prefixFactors = factorsOf(num);
        int firstZero = num.indexOf('0');
        int boundary = (firstZero == -1) ? num.length() : firstZero;

        if (firstZero == -1 && isSubset(need, prefixFactors)) {
            return num; // num itself already works
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            prefixFactors = subtract(prefixFactors, DIGIT_FACTORS.getOrDefault(d, Map.of()));
            int spaceLeft = num.length() - 1 - i;

            if (i > boundary) continue;

            for (int bigger = d + 1; bigger <= 9; bigger++) {
                Map<Integer, Integer> remaining = subtract(
                        subtract(need, prefixFactors),
                        DIGIT_FACTORS.getOrDefault(bigger, Map.of()));
                Map<Integer, Integer> fillDigits = digitsForFactors(remaining);
                int used = total(fillDigits);
                if (used <= spaceLeft) {
                    int ones = spaceLeft - used;
                    return num.substring(0, i)
                            + bigger
                            + "1".repeat(ones)
                            + buildFromDigitCounts(fillDigits);
                }
            }
        }

        // Need one extra digit
        Map<Integer, Integer> extForm = digitsForFactors(need);
        int ones = num.length() + 1 - total(extForm);
        return "1".repeat(ones) + buildFromDigitCounts(extForm);
    }

    // Factorize t into powers of 2,3,5,7; null if t has other prime factors
    private Map<Integer, Integer> factorizeT(long t) {
        Map<Integer, Integer> count = new HashMap<>(Map.of(2, 0, 3, 0, 5, 0, 7, 0));
        for (int p : new int[]{2, 3, 5, 7}) {
            while (t % p == 0) {
                t /= p;
                count.merge(p, 1, Integer::sum);
            }
        }
        return t == 1 ? count : null;
    }

    private Map<Integer, Integer> factorsOf(String num) {
        Map<Integer, Integer> count = new HashMap<>(Map.of(2, 0, 3, 0, 5, 0, 7, 0));
        for (char c : num.toCharArray()) {
            for (Map.Entry<Integer, Integer> e : DIGIT_FACTORS.getOrDefault(c - '0', Map.of()).entrySet()) {
                count.merge(e.getKey(), e.getValue(), Integer::sum);
            }
        }
        return count;
    }

    // Greedy: fewest digits (using 8,9,6,4 etc.) to cover required prime counts
    private Map<Integer, Integer> digitsForFactors(Map<Integer, Integer> need) {
        int c2 = Math.max(0, need.getOrDefault(2, 0));
        int c3 = Math.max(0, need.getOrDefault(3, 0));
        int c5 = Math.max(0, need.getOrDefault(5, 0));
        int c7 = Math.max(0, need.getOrDefault(7, 0));

        int count8 = c2 / 3;
        int rem2 = c2 % 3;
        int count9 = c3 / 2;
        int count3 = c3 % 2;
        int count4 = rem2 / 2;
        int count2 = rem2 % 2;
        int count6 = 0;

        if (count2 == 1 && count3 == 1) {
            count2 = 0; count3 = 0; count6 = 1;
        }
        if (count3 == 1 && count4 == 1) {
            count2 = 1; count6 = 1; count3 = 0; count4 = 0;
        }

        Map<Integer, Integer> res = new HashMap<>();
        res.put(2, count2); res.put(3, count3); res.put(4, count4);
        res.put(5, c5); res.put(6, count6); res.put(7, c7);
        res.put(8, count8); res.put(9, count9);
        return res;
    }

    private String buildFromDigitCounts(Map<Integer, Integer> counts) {
        StringBuilder sb = new StringBuilder();
        for (int d = 2; d <= 9; d++) {
            sb.append(String.valueOf(d).repeat(counts.getOrDefault(d, 0)));
        }
        return sb.toString();
    }

    private boolean isSubset(Map<Integer, Integer> need, Map<Integer, Integer> have) {
        for (Map.Entry<Integer, Integer> e : need.entrySet()) {
            if (have.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
        }
        return true;
    }

    private Map<Integer, Integer> subtract(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> res = new HashMap<>(a);
        for (Map.Entry<Integer, Integer> e : b.entrySet()) {
            res.merge(e.getKey(), -e.getValue(), Integer::sum);
            res.put(e.getKey(), Math.max(0, res.get(e.getKey())));
        }
        return res;
    }

    private int total(Map<Integer, Integer> counts) {
        return counts.values().stream().mapToInt(Integer::intValue).sum();
    }
}