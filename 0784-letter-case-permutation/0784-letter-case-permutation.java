class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s.toCharArray(), 0, ans);
        return ans;
    }

    void backtrack(char[] chars, int index, List<String> ans) {

        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[index])) {
            backtrack(chars, index + 1, ans);
            return;
        }

        chars[index] = Character.toLowerCase(chars[index]);
        backtrack(chars, index + 1, ans);

        chars[index] = Character.toUpperCase(chars[index]);
        backtrack(chars, index + 1, ans);
    }
}