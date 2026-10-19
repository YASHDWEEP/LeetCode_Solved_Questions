class Solution {
    private static final int MAX_RANGE = 1000000;

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return arr;

        int min = arr[0];
        int max = arr[0];
        for (int ar : arr) {
            if (min > ar) {
                min = ar;
            } else if (max < ar) {
                max = ar;
            }
        }

        if (max - min > MAX_RANGE) {
            return getHeapRanks(arr);
        }

        int[] ranks = new int[max - min + 1];
        for (int ar : arr) {
            ranks[ar - min] = 1;
        }
        for (int i = 1; i < ranks.length; i++) {
            ranks[i] += ranks[i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ranks[arr[i] - min];
        }
        return res;
    }

    private int[] getHeapRanks(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(arr[a], arr[b]));
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        int[] res = new int[n];
        int rank = 0;
        int prev = 0;
        boolean first = true;

        while (!pq.isEmpty()) {
            int idx = pq.poll();
            if (first || arr[idx] != prev) {
                rank++;
                first = false;
            }
            res[idx] = rank;
            prev = arr[idx];
        }
        return res;
    }
}