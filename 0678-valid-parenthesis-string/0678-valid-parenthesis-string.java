class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                low--;
                high--;
            } else if (s.charAt(i) == '*') {
                low--;
                high++;
            }

            if (low < 0) {
                low = 0;
            }
            if (high == -1) {
                return false;
            }

        }
        return low == 0;
    }
}