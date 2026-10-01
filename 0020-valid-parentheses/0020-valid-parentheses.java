class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        int top = -1;
        char stack[] = new char[s.length()];

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack[++top] = ')';
            } 
            else if (c == '{') {
                stack[++top] = '}';
            } 
            else if (c == '[') {
                stack[++top] = ']';
            } 
            else {

                if (top == -1) {
                    return false;
                }

                if (stack[top] != c) {
                    return false;
                }

                top--;
            }
        }

        return top == -1;
    }
}