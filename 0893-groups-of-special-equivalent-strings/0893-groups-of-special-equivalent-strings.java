class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> st = new HashSet<>();
        for (String word : words) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even.append(word.charAt(i));
                } else {
                    odd.append(word.charAt(i));
                }
            }
            char[] e = even.toString().toCharArray();
            char[] o = odd.toString().toCharArray();

            Arrays.sort(e);
            Arrays.sort(o);

            String sign = new String(e) + new String(o);
            st.add(sign);

        }
        return st.size();
    }
}