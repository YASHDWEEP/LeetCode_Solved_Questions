class Solution {
    public boolean isAnagram(String s, String t) {
        int freq_s[] = new int[26];
        int freq_t[] = new int[26];
        if (s.length() != t.length() ){
            return false ;
        }
        for (int i = 0; i < s.length(); i++) {
            freq_s[s.charAt(i) - 'a']++;
            freq_t[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq_s[i] != freq_t[i]) {
                return false;
            }
        }
        return true;
    }
}