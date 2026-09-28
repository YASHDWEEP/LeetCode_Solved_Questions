class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        Stack<String> St = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                St.push(Character.toString(ch));
                count += 1;
            } else if (ch == ')') {
                St.pop();
                max = Math.max(count, max);
                count -= 1;
            }
        }
        return max;
    }
}