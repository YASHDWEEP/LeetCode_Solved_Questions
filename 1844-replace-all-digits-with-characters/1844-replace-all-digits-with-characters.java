class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i += 2) {
            int n = s.charAt(i + 1) - '0';
            char newchar = (char) (s.charAt(i) + n);
            sb.setCharAt(i + 1, newchar);

        }
        return sb.toString();
    }
}