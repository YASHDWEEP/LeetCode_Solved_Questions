class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Build target as much as possible
        for (int i = 0; i < n; i++) {

            int x = target.charAt(i) - 'a';

            if (freq[x] > 0) {
                freq[x]--;
            } else {
                // Target cannot be continued.
                // Find the smallest possible greater answer
                for (int j = i; j >= 0; j--) {

                    // Restore characters from the suffix
                    if (j < i) {
                        freq[target.charAt(j) - 'a']++;
                    }

                    int cur = target.charAt(j) - 'a';

                    for (int k = cur + 1; k < 26; k++) {
                        if (freq[k] > 0) {

                            StringBuilder ans = new StringBuilder();

                            ans.append(target.substring(0, j));
                            ans.append((char) ('a' + k));

                            freq[k]--;

                            for (int c = 0; c < 26; c++) {
                                while (freq[c] > 0) {
                                    ans.append((char) ('a' + c));
                                    freq[c]--;
                                }
                            }

                            return ans.toString();
                        }
                    }
                }

                return "";
            }
        }

        // target itself is possible.
        // Find its next lexicographical permutation.
        for (int i = n - 1; i >= 0; i--) {

            freq[target.charAt(i) - 'a']++;

            int cur = target.charAt(i) - 'a';

            for (int j = cur + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(target.substring(0, i));
                    ans.append((char) ('a' + j));

                    freq[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}