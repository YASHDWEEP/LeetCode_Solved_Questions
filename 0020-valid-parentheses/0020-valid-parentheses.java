import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> St = new Stack<>();
        if (s.length() % 2 == 1) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                St.push(c);
            } else {
                if (St.isEmpty()) {
                    return false;
                }
                char top = St.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return St.isEmpty();
    }
}