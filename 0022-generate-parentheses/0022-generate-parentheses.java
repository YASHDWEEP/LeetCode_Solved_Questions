class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentString, int openCount, int closeCount,
            int maxPairs) {
        if (currentString.length() == maxPairs * 2) {
            result.add(currentString.toString());
            return;
        }
        if (openCount < maxPairs) {
            currentString.append("(");

            backtrack(result, currentString, openCount + 1, closeCount, maxPairs);
            currentString.deleteCharAt(currentString.length() - 1);
        }
        if (closeCount < openCount) {
            currentString.append(")");
            backtrack(result, currentString, openCount, closeCount + 1, maxPairs);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}