class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (vis[i]) {
                for (int j = i * i; j < n; j += i) {
                    vis[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2 ; i < n ; i++) {
            if (vis[i]) {
                count++;
            }
        }
        return count;
    }
}