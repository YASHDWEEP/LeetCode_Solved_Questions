class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {

            if (c == 'a') {
                stack[++top] = c;
            }

            else if (c == 'b') {
                if (top == -1 || stack[top] != 'a') {
                    return false;
                }

                stack[++top] = c;
            }

            else { 
                // c == 'c'

                if (top < 1 || stack[top] != 'b' || stack[top - 1] != 'a') {
                    return false;
                }

                // Remove "ab"
                top -= 2;
            }
        }

        return top == -1;
    }
}