
import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;

        ArrayList<String> binary = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            String x = Integer.toBinaryString(nums.get(i));
            binary.add(x);
        }

        int cnt[] = new int[31];

        for (int i = 0; i < binary.size(); i++) {
            String x = binary.get(i);
            int j = x.length() - 1;
            int bit = 0;

            while (j >= 0) {
                if (x.charAt(j) == '1') {
                    cnt[bit]++;
                }

                j--;
                bit++;
            }
        }

         long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (cnt[bit] > 0) {
                    num |= (1L << bit);
                    cnt[bit]--;
                }
            }

           
            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }
}
