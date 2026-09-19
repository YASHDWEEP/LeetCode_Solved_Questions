class Solution {
    public int longestContinuousSubstring(String s) {
        int length = 1;
        int maxlength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i + 1) - s.charAt(i)) == 1) {
                length++;
            } else {
                length = 1;
            }

            maxlength = Math.max(maxlength, length);
        }
        return maxlength;
    }
}