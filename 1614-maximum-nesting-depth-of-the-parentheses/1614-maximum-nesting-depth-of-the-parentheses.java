class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count += 1;
                max = Math.max(count, max);
            } else if (ch == ')') {
                count -= 1;
            }
        }
        return max;
    }
}