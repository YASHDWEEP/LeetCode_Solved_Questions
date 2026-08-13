// class Solution {
//     private static int lengthoflongestrepeatingsubstring(String s){
//         int max = 1 ; 
//         int count =1 ; 
//         for (int i = 1 ; i < s.length() ;i++){
//             if (s.charAt(i) ==s.charAt(i-1)){
//                 count++; 
//             }else{
//                 count =1 ; 
//             }
//             max = Math.max(count,max); 
//         }
//         return max ; 
//     }
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         StringBuilder sb = new StringBuilder(s); 
        
//         int result[] = new int[queryIndices.length ]; 

//         for (int i = 0 ; i < queryIndices.length ;i++){
//             sb.setCharAt(queryIndices[i] , queryCharacters.charAt(i) );
//             int length = lengthoflongestrepeatingsubstring(sb.toString());
//             result[i] = length; 
//         }
//         return result ; 
//     }
// }
import java.util.*;

class Solution {

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {

        int n = s.length();

        char[] arr = s.toCharArray();

        // start -> length
        TreeMap<Integer, Integer> runs = new TreeMap<>();

        // length -> frequency
        TreeMap<Integer, Integer> lengthCount = new TreeMap<>();

        // Build initial runs
        int start = 0;

        for (int i = 1; i <= n; i++) {

            if (i == n || arr[i] != arr[i - 1]) {

                int len = i - start;

                runs.put(start, len);
                addLength(lengthCount, len);

                start = i;
            }
        }

        int[] result = new int[queryIndices.length];

        for (int q = 0; q < queryIndices.length; q++) {

            int idx = queryIndices[q];
            char newChar = queryCharacters.charAt(q);

            if (arr[idx] == newChar) {
                result[q] = lengthCount.lastKey();
                continue;
            }

            // Find the run containing idx
            Map.Entry<Integer, Integer> entry =
                    runs.floorEntry(idx);

            int runStart = entry.getKey();
            int runLength = entry.getValue();
            int runEnd = runStart + runLength - 1;

            // Remove old run
            removeLength(lengthCount, runLength);
            runs.remove(runStart);

            char oldChar = arr[idx];

            // Left part
            if (idx > runStart) {
                int leftLength = idx - runStart;

                runs.put(runStart, leftLength);
                addLength(lengthCount, leftLength);
            }

            // Right part
            if (idx < runEnd) {
                int rightStart = idx + 1;
                int rightLength = runEnd - idx;

                runs.put(rightStart, rightLength);
                addLength(lengthCount, rightLength);
            }

            // Update character
            arr[idx] = newChar;

            // Add new character as a run
            runs.put(idx, 1);
            addLength(lengthCount, 1);

            // Merge with left run if same character
            Map.Entry<Integer, Integer> left =
                    runs.lowerEntry(idx);

            if (left != null) {

                int leftStart = left.getKey();
                int leftLength = left.getValue();

                if (arr[leftStart] == newChar) {

                    removeLength(lengthCount, leftLength);
                    removeLength(lengthCount, 1);

                    runs.remove(leftStart);
                    runs.remove(idx);

                    int newLength = leftLength + 1;

                    runs.put(leftStart, newLength);
                    addLength(lengthCount, newLength);

                    idx = leftStart;
                }
            }

            // Merge with right run
            Map.Entry<Integer, Integer> right =
                    runs.higherEntry(idx);

            if (right != null) {

                int rightStart = right.getKey();
                int rightLength = right.getValue();

                if (arr[rightStart] == newChar) {

                    int currentLength = runs.get(idx);

                    removeLength(lengthCount, currentLength);
                    removeLength(lengthCount, rightLength);

                    runs.remove(idx);
                    runs.remove(rightStart);

                    int newLength = currentLength + rightLength;

                    runs.put(idx, newLength);
                    addLength(lengthCount, newLength);
                }
            }

            result[q] = lengthCount.lastKey();
        }

        return result;
    }

    private void addLength(TreeMap<Integer, Integer> map, int len) {
        map.put(len, map.getOrDefault(len, 0) + 1);
    }

    private void removeLength(TreeMap<Integer, Integer> map, int len) {

        int count = map.get(len);

        if (count == 1) {
            map.remove(len);
        } else {
            map.put(len, count - 1);
        }
    }
}