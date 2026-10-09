class Solution {
    public int minInsertions(String s) {
        int open = 0, insert = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open += 2;
                if ((open ^ 1) != (open + 1)) {
                    insert = insert + 1;
                    open = open - 1;
                }
            } else {
                open = open - 1;
                if (open < 0) {
                    insert += 1;
                    open = 1;
                }
            }
        }
        return insert + open;
    }
}