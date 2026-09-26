class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> Map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < knowledge.size(); i++) {
            String key = knowledge.get(i).get(0);
            String value = knowledge.get(i).get(1);
            Map.put(key, value);
        }
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                String ke = s.substring(i + 1, j);
                if (Map.containsKey(ke)) {
                    ans.append(Map.get(ke));
                } else {
                    ans.append("?");
                }
                i = j + 1;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}