class Solution {
    public int totalNumbers(int[] digits) {
        int ans = 0;
        int freq[] = new int[10];
        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]]++;
        }
        for (int num = 100; num <= 998; num++) {
            if (num % 2 != 0) {
                continue;
            }
            int used[] = new int[10];
            int n = num;
            used[n % 10]++;
            n = n / 10;
            used[n % 10]++;
            n = n / 10;
            used[n % 10]++;
            boolean possible = true;
            for (int d = 0; d <= 9; d++) {
                if (used[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                ans++;
            }
        }
        return ans;
    }
}