class Solution {
    public int longestContinuousSubstring(String s) {

        char[] ch = s.toCharArray();
        int n = ch.length;

        int ct = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {

            if (ch[i] == ch[i - 1] + 1) {
                ct++;

                if (ct > max) {
                    max = ct;
                }
            } else {
                ct = 1;
            }
        }

        return max;
    }
}