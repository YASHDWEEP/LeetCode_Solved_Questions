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
// import java.util.*;

// class Solution {

//     public int[] longestRepeating(String s, String queryCharacters,
//                                   int[] queryIndices) {

//         int n = s.length();

//         char[] arr = s.toCharArray();

//         // start -> length
//         TreeMap<Integer, Integer> runs = new TreeMap<>();

//         // length -> frequency
//         TreeMap<Integer, Integer> lengthCount = new TreeMap<>();

//         // Build initial runs
//         int start = 0;

//         for (int i = 1; i <= n; i++) {

//             if (i == n || arr[i] != arr[i - 1]) {

//                 int len = i - start;

//                 runs.put(start, len);
//                 addLength(lengthCount, len);

//                 start = i;
//             }
//         }

//         int[] result = new int[queryIndices.length];

//         for (int q = 0; q < queryIndices.length; q++) {

//             int idx = queryIndices[q];
//             char newChar = queryCharacters.charAt(q);

//             if (arr[idx] == newChar) {
//                 result[q] = lengthCount.lastKey();
//                 continue;
//             }

//             // Find the run containing idx
//             Map.Entry<Integer, Integer> entry =
//                     runs.floorEntry(idx);

//             int runStart = entry.getKey();
//             int runLength = entry.getValue();
//             int runEnd = runStart + runLength - 1;

//             // Remove old run
//             removeLength(lengthCount, runLength);
//             runs.remove(runStart);

//             char oldChar = arr[idx];

//             // Left part
//             if (idx > runStart) {
//                 int leftLength = idx - runStart;

//                 runs.put(runStart, leftLength);
//                 addLength(lengthCount, leftLength);
//             }

//             // Right part
//             if (idx < runEnd) {
//                 int rightStart = idx + 1;
//                 int rightLength = runEnd - idx;

//                 runs.put(rightStart, rightLength);
//                 addLength(lengthCount, rightLength);
//             }

//             // Update character
//             arr[idx] = newChar;

//             // Add new character as a run
//             runs.put(idx, 1);
//             addLength(lengthCount, 1);

//             // Merge with left run if same character
//             Map.Entry<Integer, Integer> left =
//                     runs.lowerEntry(idx);

//             if (left != null) {

//                 int leftStart = left.getKey();
//                 int leftLength = left.getValue();

//                 if (arr[leftStart] == newChar) {

//                     removeLength(lengthCount, leftLength);
//                     removeLength(lengthCount, 1);

//                     runs.remove(leftStart);
//                     runs.remove(idx);

//                     int newLength = leftLength + 1;

//                     runs.put(leftStart, newLength);
//                     addLength(lengthCount, newLength);

//                     idx = leftStart;
//                 }
//             }

//             // Merge with right run
//             Map.Entry<Integer, Integer> right =
//                     runs.higherEntry(idx);

//             if (right != null) {

//                 int rightStart = right.getKey();
//                 int rightLength = right.getValue();

//                 if (arr[rightStart] == newChar) {

//                     int currentLength = runs.get(idx);

//                     removeLength(lengthCount, currentLength);
//                     removeLength(lengthCount, rightLength);

//                     runs.remove(idx);
//                     runs.remove(rightStart);

//                     int newLength = currentLength + rightLength;

//                     runs.put(idx, newLength);
//                     addLength(lengthCount, newLength);
//                 }
//             }

//             result[q] = lengthCount.lastKey();
//         }

//         return result;
//     }

//     private void addLength(TreeMap<Integer, Integer> map, int len) {
//         map.put(len, map.getOrDefault(len, 0) + 1);
//     }

//     private void removeLength(TreeMap<Integer, Integer> map, int len) {

//         int count = map.get(len);

//         if (count == 1) {
//             map.remove(len);
//         } else {
//             map.put(len, count - 1);
//         }
//     }
// }
class Solution {
    private static class SegmentTree {
        private final int n;
        private final int[] pre;
        private final int[] suf;
        private final int[] best;
        private final char[] cs;

        public SegmentTree(String s) {
            n = s.length();
            pre = new int[n << 2];
            suf = new int[n << 2];
            best = new int[n << 2];
            cs = s.toCharArray();

            build(1, 0, n - 1);
        }

        private void build(int node, int l, int r) {
            if (l == r) {
                pre[node] = suf[node] = best[node] = 1;
                return;
            }
            int mid = (l + r) >>> 1;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);
            pushUp(node, l, r);
        }

        private void pushUp(int node, int l, int r) {
            int left = node << 1;
            int right = node << 1 | 1;
            int mid = (l + r) >>> 1;
            int lenL = mid - l + 1;
            int lenR = r - mid;

            pre[node] = pre[left];
            suf[node] = suf[right];
            best[node] = Math.max(best[left], best[right]);
            if (cs[mid] == cs[mid + 1]) {
                if (pre[left] == lenL) {
                    pre[node] = lenL + pre[right];
                }
                if (suf[right] == lenR) {
                    suf[node] = lenR + suf[left];
                }
                best[node] = Math.max(best[node], suf[left] + pre[right]);
            }
        }

        public void update(int i) {
            update(1, 0, n - 1, i);
        }

        private void update(int node, int l, int r, int i) {
            if (l == r) {
                return;
            }
            int mid = (l + r) >>> 1;
            if (i <= mid) {
                update(node << 1, l, mid, i);
            } else {
                update(node << 1 | 1, mid + 1, r, i);
            }
            pushUp(node, l, r);
        }

        public void updateChar(char c, int i) {
            cs[i] = c;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryIndices.length;
        SegmentTree tree = new SegmentTree(s);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int index = queryIndices[i];
            tree.updateChar(queryCharacters.charAt(i), index);
            tree.update(index);
            ans[i] = tree.best[1];
        }
        return ans;
    }
}