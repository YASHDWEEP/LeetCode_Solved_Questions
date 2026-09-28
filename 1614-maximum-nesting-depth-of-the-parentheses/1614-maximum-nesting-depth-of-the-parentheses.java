class Solution {
    public int maxDepth(String s) {
        int count = 0, max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count += 1;
                if (max < count) {
                    max = count;
                }
            } else if (ch == ')') {
                count -= 1;
            }
        }
        return max;
    }
}