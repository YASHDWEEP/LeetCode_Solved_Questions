class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();

        // Stack to find matching parentheses
        Deque<Integer> stk = new ArrayDeque<>();

        // pair[i] stores the matching bracket index
        int[] pair = new int[n];

        // Step 1: Find matching parentheses
        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stk.push(i);

            } else if (ch == ')') {

                int open = stk.pop();

                pair[open] = i;
                pair[i] = open;
            }
        }

        // Step 2: Traverse the string
        StringBuilder sb = new StringBuilder();

        int direction = 1;

        for (int i = 0; i < n; i += direction) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {

                // Jump to matching bracket
                i = pair[i];

                // Change direction
                direction = -direction;

            } else {

                // Add normal character
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}