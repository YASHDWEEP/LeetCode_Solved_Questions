class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            }
            if (depth > 1) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                depth--;
            }

        }
        return sb.toString();
    }
}