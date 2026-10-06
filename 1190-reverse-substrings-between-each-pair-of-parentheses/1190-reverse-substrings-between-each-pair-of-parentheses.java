class Solution {
    public String reverseParentheses(String s) {
        Stack<String> ST = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ST.push(curr.toString());
                curr = new StringBuilder();
            } else if (ch == ')') {
                curr.reverse();
                String prev = ST.pop();
                curr = new StringBuilder(prev + curr);
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}