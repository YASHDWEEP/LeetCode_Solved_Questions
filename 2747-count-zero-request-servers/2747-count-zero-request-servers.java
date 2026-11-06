// class Solution {
//     public int[] countServers(int n, int[][] logs, int x, int[] queries) {
//         int[] arr = new int[queries.length];
//          HashSet<Integer> HS ; 
//         for (int i = 0; i < queries.length; i++) {
//             int start_time = queries[i] - x;
//             int end_time = queries[i];

//             HS = new HashSet<>();
//             for (int j = 0; j < logs.length; j++) {
//                 if (start_time <= logs[j][1] && logs[j][1] <= end_time) {
//                     HS.add(logs[j][0]);
//                 }
//             }
//             arr[i] = n - HS.size();
//         }
//         return arr;
//     }
// }

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) ->
            Integer.compare(queries[a], queries[b])
        );

        int[] ans = new int[q];

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int idx : indices) {

            int query = queries[idx];

            while (right < m && logs[right][1] <= query) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;
            }

            while (left < right && logs[left][1] < query - x) {

                int server = logs[left][0];

                if (map.get(server) == 1) {
                    map.remove(server);
                } else {
                    map.put(server, map.get(server) - 1);
                }

                left++;
            }

                    ans[idx] = n - map.size();
        }

        return ans;
    }
}
