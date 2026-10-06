class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < knowledge.size(); i++) {
            String key = knowledge.get(i).get(0);
            String value = knowledge.get(i).get(1);
            map.put(key, value);
        }
        int i = 0;
        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (!(s.charAt(j) == ')')) {
                    j++;
                }
                String new_key = s.substring(i + 1, j);
                if (map.containsKey(new_key)) {
                    sb.append(map.get(new_key));
                } else {
                    sb.append("?");
                }
                i = j;
            } else {
                sb.append(s.charAt(i));

            }
            i++;
        }
        return sb.toString();
    }
}